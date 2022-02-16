package main.br.com.techdive.habilitpro.representation.request;

import lombok.Getter;
import lombok.Setter;
import main.br.com.techdive.habilitpro.domain.PerfilAcesso;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Getter
@Setter
@Builder
public class UsuarioRequestRepresentation {

    private String cpf;

    private String nome;

    private String email;

    private String senha;

    private List<PerfilAcesso> perfisAcesso;
}
