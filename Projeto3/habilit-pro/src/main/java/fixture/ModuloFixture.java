package fixture;

import model.entities.Modulo;
import model.entities.Status;
import model.entities.Trilha;

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
                .habilidades("Habilidade1")
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
