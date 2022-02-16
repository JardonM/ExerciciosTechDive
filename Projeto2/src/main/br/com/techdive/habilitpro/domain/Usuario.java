package main.br.com.techdive.habilitpro.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Usuario {

    private String cpf;

    private String nome;

    private String email;

    private String senha;

    private List<PerfilAcesso> perfisAcesso;
}
