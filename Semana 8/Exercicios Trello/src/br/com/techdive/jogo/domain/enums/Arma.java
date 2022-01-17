package br.com.techdive.jogo.domain.enums;

public enum Arma {
    ESPADA("Espada", 5, "com sua espada"),
    MACHADO("Machado", 5, "com seu machado"),
    MARTELO("Martelo", 5, "com seu martelo"),
    CLAVA("Clava", 5, "com sua clava"),
    ARCO("Arco", 5, "com seu arco, a flecha atingiu"),
    BESTA("Besta", 5, "com sua besta, o virote atingiu"),
    CAJADO("Cajado", 5, "com seu cajado, lancando uma bola de fogo"),
    LIVRO_DE_MAGIAS("Magic Book", 5, "com seu Magic Book, absorvendo a energia com uma mao e liberando com a outra"),
    ARMADILHA("Trap Kit", 2),
    MACHADO_DUPLO("Machado Duplo", 7);

    private String descricao;
    private int value;
    private String fraseAtaque;

    Arma(String descricao, int value, String fraseAtaque) {
        this.descricao = descricao;
        this.value = value;
        this.fraseAtaque = fraseAtaque;
    }

    Arma(String descricao, int value) {
        this.descricao = descricao;
        this.value = value;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValue() {
        return value;
    }

    public String getFraseAtaque() {
        return fraseAtaque;
    }
}
