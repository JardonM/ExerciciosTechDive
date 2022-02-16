package br.com.techdive.habilitpro.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Trabalhador {

    private Long id;

    private String nome;

    private String cpf;

    private Empresa empresa;

    private String setor;

    private String funcao;

    private LocalDateTime ultimaAlteracaoFuncao;

    private List<Trilha> trilhas;

    private List<Modulo> modulos;



}
