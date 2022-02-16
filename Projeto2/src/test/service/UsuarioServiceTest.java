package test.service;

import main.br.com.techdive.habilitpro.domain.PerfilAcesso;
import main.br.com.techdive.habilitpro.repository.UsuarioRepository;
import main.br.com.techdive.habilitpro.representation.request.UsuarioRequestRepresentation;
import main.br.com.techdive.habilitpro.service.UsuarioService;

import java.util.List;

public class UsuarioServiceTest {

    public static void main(String[] args) {
        //Para testar cenarios de erro pode alterar este objeto ou criar outros
        UsuarioService usuarioService = new UsuarioService();
        usuarioService.cadastrarUsuario(UsuarioRequestRepresentation.builder()
                .cpf("010.020.030-01")
                .email("primeiro@usuario.com")
                .nome("Primeiro Usuario")
                .perfisAcesso(List.of(PerfilAcesso.ADMINISTRATIVO, PerfilAcesso.OPERACIONAL))
                .senha("Pr1m3ir0")
                .build());
        System.out.println(UsuarioRepository.usuarios.get("010.020.030-01"));

        usuarioService.alterarPerfisAcesso("010.020.030-01", List.of(PerfilAcesso.ADMINISTRATIVO, PerfilAcesso.RH, PerfilAcesso.OPERACIONAL));

        System.out.println(UsuarioRepository.usuarios.get("010.020.030-01"));
    }

}
