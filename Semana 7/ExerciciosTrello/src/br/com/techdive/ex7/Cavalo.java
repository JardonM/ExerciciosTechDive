package br.com.techdive.ex7;

public class Cavalo extends Animal{
    public Cavalo(String nome, int idade) {
        super(nome, idade);
    }

    public Cavalo() {
    }

    @Override
    public void emitirSom() {
        System.out.println("Relinchando");
    }

    @Override
    public void locomover() {
        System.out.println("Correndo...");
    }
}
