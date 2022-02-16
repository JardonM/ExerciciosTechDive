package br.com.techdive.habilitpro.representation.request;

import br.com.techdive.habilitpro.domain.Empresa;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class TrilhaRequestRepresentation {


    private String cnpjEmpresa;

    private String ocupacao;

    private String nome;

    private String apelido;

    private int quantidadeModulos;

    private Empresa empresa;

    private String anotacoes;
}
