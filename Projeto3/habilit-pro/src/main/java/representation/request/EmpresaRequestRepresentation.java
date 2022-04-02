package representation.request;

import lombok.*;
import model.entities.EnumEmpresa;
import model.entities.SegmentoAtuacao;

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

    private Optional<List<Long>> idFiliais;

}
