package br.com.techdive.ex7;

public class Preguica extends Animal{

    public Preguica(String nome, int idade) {
        super(nome, idade);
    }

    public Preguica() {
    }

    @Override
    public void emitirSom() {
        System.out.println("Som de preguica");
    }

    @Override
    public void locomover() {
        System.out.println("Escalar arvore");
    }
}
