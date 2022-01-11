package br.com.techdive.jogo.domain;

public abstract class Personagem {
    private int saude;
    private int pontosAtq;
    private int pontosDef;

    public Personagem(int saude, int pontosAtq, int pontosDef) {
        this.saude = saude;
        this.pontosAtq = pontosAtq;
        this.pontosDef = pontosDef;
    }

}
