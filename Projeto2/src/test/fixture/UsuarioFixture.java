package test.fixture;

import main.br.com.techdive.habilitpro.domain.*;

import java.util.List;

public class UsuarioFixture {

    private Usuario usuario;

    public static UsuarioFixture get() {
        return new UsuarioFixture();
    }

    public UsuarioFixture withRandomData() {
        usuario = Usuario.builder()
                .cpf("919.929.939-91")
                .email("primeiro@usuario.com")
                .nome("Primeiro Usuario")
                .perfisAcesso(List.of(PerfilAcesso.ADMINISTRATIVO, PerfilAcesso.OPERACIONAL))
                .senha("Pr1m3ir0")
                .build();
        return this;
    }

    public Usuario build() {
        return usuario;
    }
}
