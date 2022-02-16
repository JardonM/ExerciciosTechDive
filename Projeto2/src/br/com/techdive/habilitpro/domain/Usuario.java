package br.com.techdive.habilitpro.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Usuario {

    private String cpf;

    private String nome;

    private String email;

    private String senha;

    private List<PerfilAcesso> perfisAcesso;
}
