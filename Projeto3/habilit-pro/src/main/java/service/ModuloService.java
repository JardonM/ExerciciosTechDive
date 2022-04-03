package service;

import model.dao.AvaliacaoRepository;
import model.dao.ModuloRepository;
import model.dao.TrabalhadorRepository;
import model.dao.TrilhaRepository;
import model.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import representation.request.ModuloRequestRepresentation;

import javax.persistence.EntityManager;
import java.time.OffsetDateTime;

import static java.util.Objects.isNull;

public class ModuloService {

    private final Logger LOG = LogManager.getLogger(ModuloService.class);

    private final ModuloRepository moduloRepository;
    private final TrilhaRepository trilhaRepository;
    private final TrabalhadorRepository trabalhadorRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    private EntityManager entityManager;

    public ModuloService(EntityManager entityManager) {
        this.moduloRepository = new ModuloRepository(entityManager);
        this.trilhaRepository = new TrilhaRepository(entityManager);
        this.trabalhadorRepository = new TrabalhadorRepository(entityManager);
        this.avaliacaoRepository = new AvaliacaoRepository(entityManager);
        this.entityManager = entityManager;
    }

    public void cadastrarModulo(ModuloRequestRepresentation request, Usuario usuario) {
        this.LOG.info("Inicio do processo de cadastro de Modulo");
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        request.setTrilha(trilhaRepository.findByName(request.getNomeTrilha())
                .orElseThrow(() -> {
                    this.LOG.error("Trilha não encontrada!");
                    return new RuntimeException("Trilha inválida!");
                }));
        int diasPrazo = request.getDiasPrazo().isPresent() ? request.getDiasPrazo().get() : 10;

        this.LOG.info("Criando o modulo");
        getBeginTransaction();
        moduloRepository.create(Modulo.builder()
                .nome(request.getNome())
                .trilha(request.getTrilha())
                .status(Status.NAO_INICIADO)
                .diasPrazo(diasPrazo)
                .habilidades(request.getHabilidades())
                .tarefaValidacao(request.getTarefaValidacao())
                .build());
        this.LOG.info("Modulo criado com sucesso!");
        commitAndCloseTransaction();
    }

    public void atualizarStatus(Long id, Status status, Usuario usuario) {
        this.LOG.info("Inicio do processo de atualizar status do Modulo");
        VerificaPerfilAcesso.verificaPerfilParaAlterar(usuario);
        Modulo moduloEncontrado = moduloRepository.getById(id);
        if (isNull(moduloEncontrado)) {
            this.LOG.error("Modulo não encontrado!");
            throw new RuntimeException("Modulo inexistente!");
        }
        if (status.equals(Status.EM_ANDAMENTO)) {
            moduloEncontrado.setDataInicio(OffsetDateTime.now());
            moduloEncontrado.setPrazoLimite(OffsetDateTime.now().plusDays(moduloEncontrado.getDiasPrazo()));
        }
        if (status.equals(Status.FASE_AVALIACAO)) {
            moduloEncontrado.setDataEncerramento(OffsetDateTime.now());
        }
        moduloEncontrado.setStatus(status);
        getBeginTransaction();
        moduloRepository.update(moduloEncontrado);
        this.LOG.info("Modulo atualizado com sucesso!");
        commitAndCloseTransaction();
    }

    public void avaliarTrabalhador(Long idModulo, Long idTrabalhador, Integer nota, Usuario usuario) {
        this.LOG.info("Inicio do processo de avaliar trabalhador do Modulo");
        VerificaPerfilAcesso.verificaPerfilParaAlterar(usuario);
        Modulo moduloEncontrado = moduloRepository.getById(idModulo);
        Trabalhador trabalhadorEncontrado = trabalhadorRepository.getById(idTrabalhador);
        if (isNull(moduloEncontrado)) {
            this.LOG.error("Modulo não encontrado!");
            throw new RuntimeException("Modulo inexistente!");
        }
        if (isNull(trabalhadorEncontrado)) {
            this.LOG.error("Trabalhador não encontrado!");
            throw new RuntimeException("Trabalhador inexistente!");
        }
        validarModuloParaAvaliacao(moduloEncontrado, trabalhadorEncontrado);
        this.LOG.info("Salvando avaliação do trabalhador");
        Avaliacao avaliacao = Avaliacao.builder()
                .modulo(moduloEncontrado)
                .trabalhador(trabalhadorEncontrado)
                .nota(nota)
                .build();
        getBeginTransaction();
        trabalhadorEncontrado.getAvaliacoes().add(avaliacao);
        trabalhadorRepository.update(trabalhadorEncontrado);
        avaliacaoRepository.save(avaliacao);
        this.LOG.info("Trabalhador avaliado com sucesso!");
        commitAndCloseTransaction();
    }

    private void validarModuloParaAvaliacao(Modulo modulo, Trabalhador trabalhador) {
        if (modulo.getStatus().equals(Status.AVALIACAO_FINALIZADA)) {
            this.LOG.error("Modulo já finalizado!");
            throw new RuntimeException("Modulo já finalizado!");
        }
        if (modulo.getStatus().equals(Status.FASE_AVALIACAO)) {
            OffsetDateTime dataAtual = OffsetDateTime.now();
            if (dataAtual.isAfter(modulo.getPrazoLimite())) {
                this.LOG.error("Prazo limite excedido!");
                throw new RuntimeException("Prazo limite excedido!");
            }
        }
        if (trabalhador.getModulos().stream().noneMatch(moduloTrabalhador -> modulo.getId().equals(moduloTrabalhador.getId()))) {
            this.LOG.error("Trabalhador não está inscrito neste modulo!");
            throw new RuntimeException("Trabalhador não está inscrito neste modulo!");
        }
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
