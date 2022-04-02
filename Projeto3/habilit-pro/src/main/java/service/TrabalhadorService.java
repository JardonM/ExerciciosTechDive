package service;

import lombok.var;
import model.dao.*;
import model.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import representation.request.TrabalhadorRequestRepresentation;

import java.time.LocalDateTime;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class TrabalhadorService {

    private static final String CPF_REGEX = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})";

    private final Logger LOG = LogManager.getLogger(TrabalhadorService.class);

    private TrabalhadorRepository trabalhadorRepository;
    private final EmpresaService empresaService;
    private final TrilhaRepository trilhaRepository;
    private final FuncaoRepository funcaoRepository;
    private final SetorRepository setorRepository;
    private final HistoricoFuncaoRepository historicoFuncaoRepository;

    public TrabalhadorService(TrabalhadorRepository trabalhadorRepository, EmpresaService empresaService, TrilhaRepository trilhaRepository,
                              FuncaoRepository funcaoRepository, SetorRepository setorRepository, HistoricoFuncaoRepository historicoFuncaoRepository) {
        this.trabalhadorRepository = trabalhadorRepository;
        this.empresaService = empresaService;
        this.trilhaRepository = trilhaRepository;
        this.funcaoRepository = funcaoRepository;
        this.setorRepository = setorRepository;
        this.historicoFuncaoRepository = historicoFuncaoRepository;
    }

    public void cadastrarTrabalhador(TrabalhadorRequestRepresentation request, Usuario usuario) {
        this.LOG.info("Inicio do processo de cadastro de trabalhador");
        trabalhadorRepository = new TrabalhadorRepository();
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        verificaTrabalhador(request.getNome(), request.getSetor(), request.getFuncao());
        verificaCpf(request.getCpf());

        this.LOG.info("Cadastrando trabalhador");
        var historico = HistoricoFuncao.builder()
                .dataInicio(LocalDateTime.now())
                .funcao(funcaoRepository.save(Funcao.builder().nomeFuncao(request.getFuncao()).build()))
                .build();

        trabalhadorRepository.create(Trabalhador.builder()
                .idEmpresa(empresaService.buscarEmpresa(request.getCnpjEmpresa()).getId())
                .nome(request.getNome())
                .cpf(request.getCpf())
                .setor(setorRepository.save(Setor.builder().nomeSetor(request.getSetor()).build()))
                .funcao(historico.getFuncao())
                .ultimaAlteracaoFuncao(LocalDateTime.now())
                .trilhas(request.getTrilhas())
                .modulos(request.getModulos())
                .historicoFuncoes(asList(historicoFuncaoRepository.save(historico)))
                .build());
        this.LOG.info("Trabalhador cadastrado com sucesso!");
    }

    public void adicionarTrilha(String nomeTrilha, String cpf, Usuario usuario) {
        this.LOG.info("Inicio do processo de adicionar trilha ao trabalhador");
        VerificaPerfilAcesso.verificaPerfilParaAdicionar(usuario);
        verificaCpf(cpf);
        var trabalhador = buscaTrabalhador(cpf);
        var trilha = trilhaRepository.findByName(nomeTrilha)
                .orElseThrow(() -> {
                    this.LOG.error("Trilha nao encontrada");
                    return new RuntimeException("Trilha inválida!");
                });
        trabalhador.getTrilhas().add(trilha);
        trilha.getTrabalhadores().add(trabalhador);

        trilhaRepository.update(trilha);
        trabalhadorRepository.update(trabalhador);
        this.LOG.info("Trilha adicionada com sucesso!");
    }

    public void alterarFuncao(String funcao, String cpf, Usuario usuario) {
        this.LOG.info("Inicio do processo de alterar funcao do trabalhador");

        VerificaPerfilAcesso.verificaPerfilParaAlterar(usuario);
        verificaCpf(cpf);

        Trabalhador trabalhador = buscaTrabalhador(cpf);
        verificaFuncao(funcao, trabalhador.getFuncao().getNomeFuncao());

        var funcaoBanco = funcaoRepository.findByName(funcao);
        if (funcaoBanco.isPresent()) {
            trabalhador.setFuncao(funcaoBanco.get());
        } else {
            trabalhador.setFuncao(funcaoRepository.save(Funcao.builder().nomeFuncao(funcao).build()));
        }

        trabalhador.getHistoricoFuncoes().get(trabalhador.getHistoricoFuncoes().size() - 1)
                .setDataFim(LocalDateTime.now());

        historicoFuncaoRepository.save(trabalhador.getHistoricoFuncoes()
                .get(trabalhador.getHistoricoFuncoes().size() - 1));
        this.LOG.info("Funcao antiga salva com sucesso no historico de funcoes!");

        trabalhador.getHistoricoFuncoes().add(historicoFuncaoRepository.save(HistoricoFuncao.builder()
                .funcao(trabalhador.getFuncao())
                .dataInicio(LocalDateTime.now())
                .build()));

        trabalhador.setUltimaAlteracaoFuncao(trabalhador.getHistoricoFuncoes()
                .get(trabalhador.getHistoricoFuncoes().size() - 1).getDataInicio());

        trabalhadorRepository.update(trabalhador);
        this.LOG.info("Funcao alterada com sucesso!");
    }

    public void alterarEmpresa(String cpf, String cnpj) {
        this.LOG.info("Inicio do processo de alterar empresa do trabalhador");

        verificaCpf(cpf);
        empresaService.verificaCnpj(cnpj);
        Trabalhador trabalhador = buscaTrabalhador(cpf);
        Empresa empresa = empresaService.buscarEmpresa(cnpj);

        trabalhador.setIdEmpresa(empresa.getId());
        trabalhadorRepository.update(trabalhador);
        this.LOG.info("Empresa alterada com sucesso!");
    }

    public Trabalhador buscaTrabalhador(String cpf) {
        this.LOG.info("Inicio do processo de busca de trabalhador");
        return trabalhadorRepository.findByCpf(cpf)
                .orElseThrow(() -> {
                    this.LOG.error("Trabalhador nao encontrado");
                    return new RuntimeException("CPF não cadastrado!");
                });
    }

    private void verificaFuncao(String novaFuncao, String funcaoTrabalhador) {
        this.LOG.info("Inicio do processo de verificação de funcao");

        if (novaFuncao.equalsIgnoreCase(funcaoTrabalhador)) {
            this.LOG.info("Funcao não alterada");
            throw new RuntimeException("Está já é a função atual do trabalhador!");
        }

        this.LOG.info("Funcao verificada com sucesso!");
    }

    private void verificaTrabalhador(String nome, String nomeSetor, String nomeFuncao) {
        this.LOG.info("Inicio do processo de verificação dos dados gerais do trabalhador");

        if (nome.isEmpty()) {
            this.LOG.info("Nome não informado");
            throw new RuntimeException("O trabalhador deve ter um nome!");
        }

        if (nomeSetor.isEmpty()) {
            this.LOG.info("Setor não informado");
            throw new RuntimeException("O trabalhador deve ter um setor!");
        }

        if (nomeFuncao.isEmpty()) {
            this.LOG.info("Funcao não informada");
            throw new RuntimeException("O trabalhador deve ter uma função!");
        }

        this.LOG.info("Dados gerais verificados com sucesso!");
    }

    private void verificaCpf(String cpf) {
        this.LOG.info("Inicio do processo de verificação do CPF");

        if (!cpf.matches(CPF_REGEX)) {
            this.LOG.info("CPF inválido");
            throw new RuntimeException("CPF está em um formato inválido!");
        }

        this.LOG.info("CPF verificado com sucesso!");
    }


}
