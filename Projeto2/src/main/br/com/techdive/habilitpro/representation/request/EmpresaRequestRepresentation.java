package main.br.com.techdive.habilitpro.representation.request;

import lombok.*;
import main.br.com.techdive.habilitpro.domain.EnumEmpresa;
import main.br.com.techdive.habilitpro.domain.SegmentoAtuacao;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EmpresaRequestRepresentation {

    private String nome;

    private String cnpj;

    private String tipoEmpresa;

    private String segmentoAtuacao;

    private EnumEmpresa enumTipoEmpresa;

    private SegmentoAtuacao enumSegmentoAtuacao;

    private Optional<List<String>> nomeFiliais;

}
