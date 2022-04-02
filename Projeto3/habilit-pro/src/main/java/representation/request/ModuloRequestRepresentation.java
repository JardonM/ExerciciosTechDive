package representation.request;

import lombok.*;
import model.entities.Status;
import model.entities.Trilha;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ModuloRequestRepresentation {

    private Trilha trilha;

    private String nomeTrilha;

    private String nome;

    private String habilidades;

    private String tarefaValidacao;

    private Status status;

    private Optional<Integer> diasPrazo;

}
