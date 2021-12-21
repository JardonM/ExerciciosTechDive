package br.com.techdive.exercicio1.domain;

public class Carro {
    private Categoria categoria;
    private int numero;
    private String marca;
    private double potencia;
    private double capacidadeCombustivel;
    private double velocidadeAtual;
    private double velocidadeMaximaRegistrada;
    public int voltas;

    public Carro(Categoria categoria, int numero, String marca, double potencia, double capacidadeCombustivel, double velocidadeAtual, double velocidadeMaximaRegistrada) {
        this.categoria = categoria;
        this.numero = numero;
        this.marca = marca;
        this.potencia = potencia;
        this.capacidadeCombustivel = capacidadeCombustivel;
        this.velocidadeAtual = velocidadeAtual;
        this.velocidadeMaximaRegistrada = velocidadeMaximaRegistrada;
    }

    public void acelera() {
        this.velocidadeAtual += 10;
    }

    public void freia() {
        this.velocidadeAtual -= 10;
    }


}
