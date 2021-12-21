package br.com.techdive.exercicio1.domain;

public enum Categoria implements StringValueEnum{
    CATEGORIA01("CATEGORIA01", "Categoria Iniciante"),
    CATEGORIA02("CATEGORIA02", "Categoria Intermediario"),
    CATEGORIA03("CATEGORIA03", "Categoria Master");

    private final String value;
    private final String displayName;

    Categoria(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }
}
