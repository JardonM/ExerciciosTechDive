package test.fixture;

import main.br.com.techdive.habilitpro.domain.Empresa;
import main.br.com.techdive.habilitpro.domain.EnumEmpresa;
import main.br.com.techdive.habilitpro.domain.SegmentoAtuacao;

import java.util.Random;

public class EmpresaFixture {

    private final Random random = new Random();
    private Empresa empresa;

    public static EmpresaFixture get() {
        return new EmpresaFixture();
    }

    public EmpresaFixture withRandomData() {
        empresa = Empresa.builder()
                .cnpj("91.929.939/9991-91")
                .tipoEmpresa(EnumEmpresa.MATRIZ)
                .nome("Primeira Empresa")
                .segmentoAtuacao(SegmentoAtuacao.ALIMENTOS_BEBIDAS)
                .id(random.nextLong())
                .build();
        return this;
    }

    public Empresa build() {
        return empresa;
    }
}
