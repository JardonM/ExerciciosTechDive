package br.com.techdive.ex9;

import br.com.techdive.ex7.Animal;

public class Veterinario {
    private String nome;

    public Veterinario(String nome) {
        this.nome = nome;
    }

    public void examinar(Animal animal) {
        animal.emitirSom();
    }
}
