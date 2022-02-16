package br.com.techdive.habilitpro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Trilha {

    private Long id;

    private Empresa empresa;

    private String ocupacao;

    private String nome;

    private String apelido;

    private int quantidadeModulos;

    private int notaSatisfacao;

    private String anotacoes;

}
