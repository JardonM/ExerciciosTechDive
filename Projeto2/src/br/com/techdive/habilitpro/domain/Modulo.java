package br.com.techdive.habilitpro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Modulo {

    private Long id;

    private Trilha trilha;
    
    private String nome;

    private List<String> habilidades;

    private String tarefaValidacao;

    private LocalDateTime prazoLimite;

    private Status status;

    private LocalDateTime dataInicio;

    private LocalDateTime dataEncerramento;

    private int diasPrazo;
}
