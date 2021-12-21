package br.com.techdive.exercicio1.domain;

public class Equipe {
    private String nome;
    private Chefe chefe;
    private Mecanico mecanico;
    private Piloto piloto;

    public Equipe(String nome, Chefe chefe, Mecanico mecanico, Piloto piloto) {
        this.nome = nome;
        this.chefe = chefe;
        this.mecanico = mecanico;
        this.piloto = piloto;
    }
}
