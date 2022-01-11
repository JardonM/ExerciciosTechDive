package br.com.techdive.jogo.domain;

public enum Motivacao {
    VINGANCA("Vincanca"),
    GLORIA("Gloria");

    private String descricao;

    Motivacao(String descricao) {
        this.descricao = descricao;
    }
}
