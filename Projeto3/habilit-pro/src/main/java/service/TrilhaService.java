package service;

import model.dao.ModuloRepository;
import model.dao.TrilhaRepository;
import model.entities.Modulo;
import model.entities.Trilha;
import model.entities.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import representation.request.TrilhaRequestRepresentation;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class TrilhaService {

    private final Logger LOG = LogManager.getLogger(TrilhaService.class);

    private final ModuloRepository moduloRepository;
    private final EmpresaService empresaService;
    private final TrilhaRepository trilhaRepository;
    private EntityManager entityManager;

    public TrilhaService(EntityManager entityManager) {
        this.moduloRepository = new ModuloRepository(entityManager);
        this.empresaService = new EmpresaService(entityManager);
        this.trilhaRepository = new TrilhaRepository(entityManager);
        this.entityManager = entityManager;
    }

    public void cadastrarTrilha(TrilhaRequestRepresentation request, Usuario usuario) {
        this.LOG.info("Inicio do processo de cadastro de trilha");

        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        request.setEmpresa(empresaService.buscarEmpresa(request.getCnpjEmpresa()));
        verificaOcupacao(request);

        List<Trilha> trilhas = trilhaRepository.listAll();
        int contadorTrilha = (int) trilhas
                .stream()
                .filter(trilha -> trilha.getOcupacao().equalsIgnoreCase(request.getOcupacao()))
                .filter(trilha -> trilha.getEmpresa().getNome().equalsIgnoreCase(request.getEmpresa().getNome()))
                .count();
        String nomeTrilha = request.getOcupacao() + request.getEmpresa().getNome() + contadorTrilha + LocalDateTime.now().getYear();
        String apelidoTrilha = request.getOcupacao() + contadorTrilha;
        this.LOG.info("Criando trilha...");

        getBeginTransaction();

        trilhaRepository.create(Trilha.builder()
                .nome(nomeTrilha)
                .apelido(apelidoTrilha)
                .anotacoes(request.getAnotacoes())
                .ocupacao(request.getOcupacao())
                .empresa(request.getEmpresa())
                .modulos(new ArrayList<>())
                .build());
        this.LOG.info("Trilha cadastrada com sucesso!");
        commitAndCloseTransaction();
    }

    private void verificaOcupacao(TrilhaRequestRepresentation request) {
        this.LOG.info("Verificando ocupação...");
        if (request.getOcupacao().isEmpty()) {
            this.LOG.info("Ocupação inválida!");
            throw new RuntimeException("A trilha deve conter uma ocupação!");
        }
        this.LOG.info("Ocupação verificada com sucesso!");
    }

    public void avaliarTrilha(String nomeTrilha, int satisfacao, Usuario usuario) {
        this.LOG.info("Inicio do processo de avaliação de trilha");
        VerificaPerfilAcesso.verificaPerfilParaAvaliar(usuario);

        Trilha trilhaEncontrada = buscarTrilha(nomeTrilha);

        if (satisfacao < 1 || satisfacao > 5) {
            this.LOG.info("Avaliação inválida!");
            throw new RuntimeException("A nota de satisfação deve ser de 1 a 5!");
        }
        trilhaEncontrada.setNotaSatisfacao(satisfacao);
        getBeginTransaction();
        trilhaRepository.update(trilhaEncontrada);
        this.LOG.info("Nota de satisfação da trilha cadastrada com sucesso!");
        commitAndCloseTransaction();
    }

    public void adicionarModulo(String nomeTrilha, Long idModulo, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaAdicionar(usuario);
        this.LOG.info("Inicio do processo de adição de módulo");
        Modulo modulo = moduloRepository.getById(idModulo);
        if(isNull(modulo)) {
            this.LOG.info("Modulo inválido!");
            throw new RuntimeException("Modulo inexistente!");
        }

        Trilha trilha = buscarTrilha(nomeTrilha);
        getBeginTransaction();
        trilha.getModulos().add(modulo);
        trilhaRepository.update(trilha);
        this.LOG.info("Modulo adicionado com sucesso!");
        commitAndCloseTransaction();
    }

    public Trilha buscarTrilha(String nomeTrilha) {
        this.LOG.info("Buscando trilha...");
        return trilhaRepository.findByName(nomeTrilha).orElseThrow(() -> {
            this.LOG.info("Trilha não encontrada!");
            return new RuntimeException("Trilha inválida!");
        });
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
