package br.com.techdive.habilitpro.service;

import br.com.techdive.habilitpro.domain.Modulo;
import br.com.techdive.habilitpro.domain.Status;
import br.com.techdive.habilitpro.domain.Usuario;
import br.com.techdive.habilitpro.repository.ModuloRepository;
import br.com.techdive.habilitpro.repository.TrilhaRepository;
import br.com.techdive.habilitpro.representation.request.ModuloRequestRepresentation;

import java.time.LocalDateTime;

public class ModuloService {

    public Modulo cadastrarModulo(ModuloRequestRepresentation request, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        request.setTrilha(TrilhaRepository.trilhas
                .stream()
                .filter(trilha -> trilha.getNome().equalsIgnoreCase(request.getNomeTrilha()))
                .findFirst()
                .orElseThrow());
        int diasPrazo = request.getDiasPrazo().isPresent() ? request.getDiasPrazo().get() : 10;

        return Modulo.builder()
                .nome(request.getNome())
                .id((long) (ModuloRepository.modulos.size() + 1))
                .trilha(request.getTrilha())
                .status(Status.NAO_INICIADO)
                .diasPrazo(diasPrazo)
                .habilidades(request.getHabilidades())
                .tarefaValidacao(request.getTarefaValidacao())
                .build();
    }

    public void atualizarStatus(Long id, Status status, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaAlterar(usuario);
        Modulo moduloEncontrado = ModuloRepository.modulos
                .stream()
                .filter(modulo -> modulo.getId().equals(id))
                .findFirst()
                .orElseThrow();
        if (status.equals(Status.EM_ANDAMENTO)) {
            moduloEncontrado.setDataInicio(LocalDateTime.now());
            moduloEncontrado.setPrazoLimite(LocalDateTime.now().plusDays(moduloEncontrado.getDiasPrazo()));
        }
        if (status.equals(Status.AVALIACAO_FINALIZADA)) {
            moduloEncontrado.setDataEncerramento(LocalDateTime.now());
        }
        moduloEncontrado.setStatus(status);
    }

}
