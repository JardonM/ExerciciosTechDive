package main.br.com.techdive.habilitpro.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Trilha {

    private Long id;

    private Empresa empresa;

    private String ocupacao;

    private String nome;

    private String apelido;

    private List<Long> idModulos;

    private int notaSatisfacao;

    private String anotacoes;

}
