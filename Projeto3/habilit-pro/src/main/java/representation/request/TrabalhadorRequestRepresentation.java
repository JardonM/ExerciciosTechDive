package representation.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.entities.Funcao;
import model.entities.Modulo;
import model.entities.Setor;
import model.entities.Trilha;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class TrabalhadorRequestRepresentation {

    private String nome;

    private String cpf;

    private String cnpjEmpresa;

    private String setor;

    private String funcao;

    private LocalDateTime ultimaAlteracaoFuncao;

    private List<Trilha> trilhas;

    private List<Modulo> modulos;
}
