package main.br.com.techdive.habilitpro.representation.request;

import lombok.Getter;
import lombok.Setter;
import main.br.com.techdive.habilitpro.domain.Modulo;
import main.br.com.techdive.habilitpro.domain.Trilha;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class TrabalhadorRequestRepresentation {

    private String nome;

    private String cpf;

    private String cnpjEmpresa;

    private String setor;

    private String funcao;

    private LocalDateTime ultimaAlteracaoFuncao;

    private List<Trilha> trilhas;

    private List<Modulo> modulos;
}
