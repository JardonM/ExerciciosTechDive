package br.com.techdive.jogo.domain;

public enum Arma {
    ESPADA("Espada"),
    MACHADO("Machado"),
    MARTELO("Martelo"),
    CLAVA("Clava"),
    ARCO("Arco"),
    BESTA("Besta"),
    CAJADO("Cajado"),
    LIVRO_DE_MAGIAS("Magic Book"),
    ARMADILHA("Trap Kit"),
    MACHADO_DUPLO("Arma do Lider");

    private String descricao;

    Arma(String descricao) {
        this.descricao = descricao;
    }
}
