package main.br.com.techdive.habilitpro.service;

import main.br.com.techdive.habilitpro.domain.Modulo;
import main.br.com.techdive.habilitpro.domain.Trilha;
import main.br.com.techdive.habilitpro.domain.Usuario;
import main.br.com.techdive.habilitpro.repository.ModuloRepository;
import main.br.com.techdive.habilitpro.repository.TrilhaRepository;
import main.br.com.techdive.habilitpro.representation.request.TrilhaRequestRepresentation;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TrilhaService {

    public Trilha cadastrarTrilha(TrilhaRequestRepresentation request, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        request.setEmpresa(EmpresaService.buscarEmpresa(request.getCnpjEmpresa()));
        verificaOcupacao(request);
        int contadorTrilha = (int) TrilhaRepository.trilhas
                .stream()
                .filter(trilha -> trilha.getOcupacao().equalsIgnoreCase(request.getOcupacao()))
                .filter(trilha -> trilha.getEmpresa().getNome().equalsIgnoreCase(request.getEmpresa().getNome()))
                .count();
        String nomeTrilha = request.getOcupacao() + request.getEmpresa().getNome() + contadorTrilha + LocalDateTime.now().getYear();
        String apelidoTrilha = request.getOcupacao() + contadorTrilha;

        System.out.println("Trilha cadastrada com sucesso!");
        Trilha trilha = Trilha.builder()
                .id((long) (TrilhaRepository.trilhas.size() + 1))
                .nome(nomeTrilha)
                .apelido(apelidoTrilha)
                .anotacoes(request.getAnotacoes())
                .ocupacao(request.getOcupacao())
                .empresa(request.getEmpresa())
                .idModulos(new ArrayList<>())
                .build();
        TrilhaRepository.trilhas.add(trilha);
        return trilha;
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

    public void adicionarModulo(String nomeTrilha, Long idModulo, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaAdicionar(usuario);
        Modulo modulo = ModuloRepository.modulos.stream()
                .filter(moduloBanco -> moduloBanco.getId().equals(idModulo))
                .findFirst()
                .orElseThrow();
        TrilhaRepository.trilhas.stream()
                .filter(trilha -> trilha.getNome().equalsIgnoreCase(nomeTrilha))
                .findFirst()
                .orElseThrow().getIdModulos().add(modulo.getId());

    }

}
