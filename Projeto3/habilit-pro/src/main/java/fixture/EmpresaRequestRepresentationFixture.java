package fixture;


import model.entities.EnumEmpresa;
import model.entities.SegmentoAtuacao;
import representation.request.EmpresaRequestRepresentation;

import java.util.Random;

public class EmpresaRequestRepresentationFixture {

    private final Random random = new Random();
    private EmpresaRequestRepresentation empresa;

    public static EmpresaRequestRepresentationFixture get() {
        return new EmpresaRequestRepresentationFixture();
    }

    public EmpresaRequestRepresentationFixture withRandomData() {
        empresa = EmpresaRequestRepresentation.builder()
                .cnpj("91.929.939/9991-91")
                .tipoEmpresa(EnumEmpresa.MATRIZ.toString())
                .nome("Primeira Empresa")
                .segmentoAtuacao(SegmentoAtuacao.ALIMENTOS_BEBIDAS.getDescription())
                .build();
        return this;
    }

    public EmpresaRequestRepresentation build() {
        return empresa;
    }
}
