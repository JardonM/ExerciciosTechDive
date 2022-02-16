package test.fixture;

import main.br.com.techdive.habilitpro.domain.Modulo;
import main.br.com.techdive.habilitpro.domain.Status;
import main.br.com.techdive.habilitpro.domain.Trilha;

import java.util.List;
import java.util.Random;

public class ModuloFixture {

    private Modulo modulo;
    private static final Random random = new Random();

    public static ModuloFixture get() {
        return new ModuloFixture();
    }

    public ModuloFixture withRandomData() {
        modulo = Modulo.builder()
                .id(random.nextLong())
                .diasPrazo(30)
                .habilidades(List.of("Habilidade1", "Habilidade2"))
                .nome("ModuloTeste")
                .status(Status.NAO_INICIADO)
                .build();
        return this;
    }

    public ModuloFixture withTrilha(Trilha trilha) {
        modulo.setTrilha(trilha);
        return this;
    }

    public Modulo build() {
        return modulo;
    }

}
