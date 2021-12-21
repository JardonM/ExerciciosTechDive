package br.com.techdive.ex7;

public abstract class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Animal() {
    }

    public void emitirSom() {
        System.out.println("Som produzido por um animal");
    }

    public void locomover() {
        System.out.println("Maneira do animal de se locomover");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
