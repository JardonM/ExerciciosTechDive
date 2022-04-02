package representation.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.entities.PerfilAcesso;

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
