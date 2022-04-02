package model.entities;

public enum EnumEmpresa {
    MATRIZ("Matriz"),
    FILIAL("Filial");

    private String description;

    EnumEmpresa(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
