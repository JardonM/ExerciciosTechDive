package br.com.techdive.habilitpro.representation.request;

import br.com.techdive.habilitpro.domain.PerfilAcesso;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsuarioRequestRepresentation {

    private String cpf;

    private String nome;

    private String email;

    private String senha;

    private List<PerfilAcesso> perfisAcesso;
}
