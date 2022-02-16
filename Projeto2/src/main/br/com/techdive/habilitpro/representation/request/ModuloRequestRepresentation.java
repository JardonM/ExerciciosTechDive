package main.br.com.techdive.habilitpro.representation.request;

import lombok.*;
import main.br.com.techdive.habilitpro.domain.Status;
import main.br.com.techdive.habilitpro.domain.Trilha;

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

    private List<String> habilidades;

    private String tarefaValidacao;

    private Status status;

    private Optional<Integer> diasPrazo;

}
