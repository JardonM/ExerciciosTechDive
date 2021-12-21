package br.com.techdive.exercicio1.domain;

public class Piloto extends Pessoa{

    private String categoria;
    private Equipe equipe;


    public Piloto(String nome, String cpf, String categoria, Equipe equipe) {
        super(nome, cpf);
        this.categoria = categoria;
        this.equipe = equipe;
    }

    public void pilota() {
        System.out.println("Pilotando");
    }
}
