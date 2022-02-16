package main.br.com.techdive.habilitpro.representation.request;

import lombok.Getter;
import lombok.Setter;
import main.br.com.techdive.habilitpro.domain.Empresa;
import lombok.Builder;
import lombok.Data;

@Getter
@Setter
@Builder
public class TrilhaRequestRepresentation {


    private String cnpjEmpresa;

    private String ocupacao;

    private Empresa empresa;

    private String anotacoes;
}
