package model.entities;

public enum Status {
    NAO_INICIADO("Curso não iniciado"),
    EM_ANDAMENTO("Curso em andamento"),
    FASE_AVALIACAO("Curso em fase de avaliação"),
    AVALIACAO_FINALIZADA("Fase de avaliação do curso finalizada");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }
}
