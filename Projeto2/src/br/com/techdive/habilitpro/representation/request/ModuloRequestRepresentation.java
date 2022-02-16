package br.com.techdive.habilitpro.representation.request;

import br.com.techdive.habilitpro.domain.Status;
import br.com.techdive.habilitpro.domain.Trilha;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ModuloRequestRepresentation {

    private Trilha trilha;

    private String nomeTrilha;

    private String nome;

    private List<String> habilidades;

    private String tarefaValidacao;

    private Status status;

    private Optional<Integer> diasPrazo;

}
