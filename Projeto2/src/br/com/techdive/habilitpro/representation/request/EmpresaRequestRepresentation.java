package br.com.techdive.habilitpro.representation.request;

import br.com.techdive.habilitpro.domain.EnumEmpresa;
import br.com.techdive.habilitpro.domain.SegmentoAtuacao;
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
public class EmpresaRequestRepresentation {

    private String nome;

    private String cnpj;

    private String tipoEmpresa;

    private String segmentoAtuacao;

    private EnumEmpresa enumTipoEmpresa;

    private SegmentoAtuacao enumSegmentoAtuacao;

    private Optional<List<String>> nomeFiliais;

}
