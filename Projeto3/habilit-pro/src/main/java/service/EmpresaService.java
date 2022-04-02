package service;

import lombok.var;
import model.dao.EmpresaRepository;
import model.entities.Empresa;
import model.entities.EnumEmpresa;
import model.entities.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import representation.request.EmpresaRequestRepresentation;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class EmpresaService {

    private final Logger LOG = LogManager.getLogger(EmpresaService.class);
    private EmpresaRepository empresaRepository;
    private EntityManager entityManager;

    private static final String CNPJ_REGEX = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})";

    public EmpresaService(EntityManager entityManager) {
        this.empresaRepository = new EmpresaRepository(entityManager);
        this.entityManager = entityManager;
    }

    public void cadastrarEmpresa(EmpresaRequestRepresentation request, Usuario usuario) {
        this.LOG.info("Inicio de procedimento de cadastro de empresa");
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        verificaCnpj(request.getCnpj());
        request.setEnumSegmentoAtuacao(DefinirSegmentoService.definir(request.getSegmentoAtuacao()));
        request.setEnumTipoEmpresa(definirHierarquia(request.getTipoEmpresa()));
        List<Empresa> filiais = nonNull(request.getIdFiliais()) ?
                request.getIdFiliais().get().stream().map(empresaRepository::getById).collect(Collectors.toList())
                : new ArrayList<>();

        this.LOG.info("Cadastrando empresa: " + request.getNome());
        getBeginTransaction();
        if (empresaRepository.existsByCnpj(request.getCnpj())) {
            this.LOG.error("CNPJ já cadastrado!");
            throw new RuntimeException("CNPJ já cadastrado!");
        }
        empresaRepository.create(Empresa.builder()
                .cnpj(request.getCnpj())
                .nome(request.getNome())
                .tipoEmpresa(request.getEnumTipoEmpresa())
                .segmentoAtuacao(request.getEnumSegmentoAtuacao())
                .filiais(filiais)
                .build());
        commitAndCloseTransaction();
        this.LOG.info("Empresa cadastrada com sucesso!");
    }

    @Transactional
    public Empresa buscarEmpresa(String cnpj) {
        this.LOG.info("Buscando empresa com cnpj: " + cnpj);
        return empresaRepository.findByCnpj(cnpj)
                .orElseThrow(() -> {
                    this.LOG.error("Empresa não encontrada!");
                    return new RuntimeException("CNPJ não cadastrado para nenhuma empresa!");
                });
    }

    public void verificaCnpj(String cnpj) {
        this.LOG.info("Verificando se o cnpj é válido: " + cnpj);
        if (!cnpj.matches(CNPJ_REGEX)) {
            this.LOG.error("CNPJ inválido!");
            throw new RuntimeException("CNPJ em formato inválido!");
        }
    }

    private EnumEmpresa definirHierarquia(String tipoEmpresa) {
        this.LOG.info("Definindo hierarquia da empresa: " + tipoEmpresa);
        if (tipoEmpresa.equalsIgnoreCase(EnumEmpresa.MATRIZ.getDescription())) {
            return EnumEmpresa.MATRIZ;
        } else if (tipoEmpresa.equalsIgnoreCase(EnumEmpresa.FILIAL.getDescription())) {
            return EnumEmpresa.FILIAL;
        } else {
            this.LOG.error("Tipo de empresa inválido!");
            throw new RuntimeException("A hierarquia da empresa inválida! Deve ser Matriz ou Filial!");
        }
    }

    public void deletarEmpresaPorCnpj(String cnpj) {
        this.LOG.info("Deletando empresa com cnpj: " + cnpj);
        verificaCnpj(cnpj);
        getBeginTransaction();
        empresaRepository.findByCnpj(cnpj).ifPresent(empresa -> {
            empresaRepository.delete(empresa);
            commitAndCloseTransaction();
            this.LOG.info("Empresa deletada com sucesso!");
        });
    }

    @Transactional
    public List<Empresa> buscarTodas() {
        this.LOG.info("Buscando todas as empresas");
        getBeginTransaction();
        var empresas = empresaRepository.findAll();
        commitAndCloseTransaction();
        this.LOG.info("Empresas buscadas com sucesso!");
        return empresas;
    }

    private void getBeginTransaction() {
        this.LOG.info("Abrindo Transação com o banco de dados...");
        entityManager.getTransaction().begin();
    }

    private void commitAndCloseTransaction() {
        this.LOG.info("Commitando e Fechando transação com o banco de dados");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
