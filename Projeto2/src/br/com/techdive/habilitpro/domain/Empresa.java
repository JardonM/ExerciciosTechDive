package br.com.techdive.habilitpro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Empresa {

    private Long id;

    private String nome;

    private String cnpj;

    private EnumEmpresa tipoEmpresa;

    private SegmentoAtuacao segmentoAtuacao;

    private Optional<List<String>> nomeFiliais;

    private List<Trilha> trilhas;

}
