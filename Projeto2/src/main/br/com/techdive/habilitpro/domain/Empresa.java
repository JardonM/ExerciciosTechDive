package main.br.com.techdive.habilitpro.domain;

import lombok.*;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Empresa {

    private Long id;

    private String nome;

    private String cnpj;

    private EnumEmpresa tipoEmpresa;

    private SegmentoAtuacao segmentoAtuacao;

    private Optional<List<String>> nomeFiliais;

x

}
