package representation.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.entities.Empresa;

@Getter
@Setter
@Builder
public class TrilhaRequestRepresentation {


    private String cnpjEmpresa;

    private String ocupacao;

    private Empresa empresa;

    private String anotacoes;
}
