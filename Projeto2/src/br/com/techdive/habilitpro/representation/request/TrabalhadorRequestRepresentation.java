package br.com.techdive.habilitpro.representation.request;

import br.com.techdive.habilitpro.domain.Modulo;
import br.com.techdive.habilitpro.domain.Trilha;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
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
