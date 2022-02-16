package br.com.techdive.habilitpro.service;

import br.com.techdive.habilitpro.domain.Empresa;
import br.com.techdive.habilitpro.domain.Trilha;
import br.com.techdive.habilitpro.domain.Usuario;
import br.com.techdive.habilitpro.repository.EmpresaRepository;
import br.com.techdive.habilitpro.repository.TrilhaRepository;
import br.com.techdive.habilitpro.representation.request.TrilhaRequestRepresentation;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class TrilhaService {

    public Trilha cadastrarTrilha(TrilhaRequestRepresentation request, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        verificaEmpresa(request);
        verificaOcupacao(request);
        int contadorTrilha = (int) TrilhaRepository.trilhas
                .stream()
                .filter(trilha -> trilha.getOcupacao().equalsIgnoreCase(request.getOcupacao()))
                .filter(trilha -> trilha.getEmpresa().getNome().equalsIgnoreCase(request.getEmpresa().getNome()))
                .count();
        String nomeTrilha = request.getOcupacao() + request.getEmpresa().getNome() + contadorTrilha + LocalDateTime.now().getYear();
        String apelidoTrilha = request.getOcupacao() + contadorTrilha;

        System.out.println("Trilha cadastrada com sucesso!");
        return Trilha.builder()
                .id((long) (TrilhaRepository.trilhas.size() + 1))
                .nome(nomeTrilha)
                .apelido(apelidoTrilha)
                .anotacoes(request.getAnotacoes())
                .ocupacao(request.getOcupacao())
                .empresa(request.getEmpresa())
                .quantidadeModulos(request.getQuantidadeModulos())
                .build();
    }

    private void verificaEmpresa(TrilhaRequestRepresentation request) {
        if(isNull(EmpresaRepository.empresas.get(request.getCnpjEmpresa()))) {
            throw new RuntimeException("A trilha deve estar associada a uma empresa!");
        }
        System.out.println("Empresa verificada com sucesso!");
    }

    private void verificaOcupacao(TrilhaRequestRepresentation request) {
        if (request.getOcupacao().isEmpty() || request.getOcupacao().isBlank()) {
            throw new RuntimeException("A trilha deve conter uma ocupação!");
        }
        System.out.println("Ocupação verificada!");
    }

    public void avaliarTrilha(String nomeTrilha, int satisfacao, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaAvaliar(usuario);
        Trilha trilhaEncontrada = TrilhaRepository.trilhas
                .stream()
                .filter(trilha -> trilha.getNome().equalsIgnoreCase(nomeTrilha))
                .findFirst()
                .orElseThrow();
        if (satisfacao < 1 || satisfacao > 5) {
            throw new RuntimeException("A nota de satisfação deve ser de 1 a 5!");
        }
        trilhaEncontrada.setNotaSatisfacao(satisfacao);
        System.out.println("Nota de satisfação da trilha cadastrada com sucesso!");
    }

}
