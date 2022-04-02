package fixture;

import model.entities.PerfilAcesso;
import model.entities.Usuario;

import java.util.Arrays;

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
                .perfisAcesso(Arrays.asList(PerfilAcesso.ADMINISTRATIVO, PerfilAcesso.OPERACIONAL))
                .senha("Pr1m3ir0")
                .build();
        return this;
    }

    public Usuario build() {
        return usuario;
    }
}
