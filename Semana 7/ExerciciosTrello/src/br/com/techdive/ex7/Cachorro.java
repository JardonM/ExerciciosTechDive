package br.com.techdive.ex7;

public class Cachorro extends Animal{


    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    public Cachorro() {
    }

    @Override
    public void emitirSom() {
        System.out.println("Au! Au! Au!");
    }

    @Override
    public void locomover() {
        System.out.println("Correndo...");
    }
}
