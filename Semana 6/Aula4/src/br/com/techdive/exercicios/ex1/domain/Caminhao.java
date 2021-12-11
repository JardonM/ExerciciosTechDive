package br.com.techdive.exercicios.ex1.domain;

public class Caminhao implements Transporte{

    private int peso;
    private String modelo;
    private String marca;
    private boolean possuiCarreta;

    public Caminhao(int peso, String modelo, String marca, boolean possuiCarreta) {
        this.peso = peso;
        this.modelo = modelo;
        this.marca = marca;
        this.possuiCarreta = possuiCarreta;
    }

    public void entregar() {
        System.out.println("Entregue.");
    }

    @Override
    public int criarTransporte() {
        return 20;
    }


    @Override
    public String toString() {
        return "Caminhao{" +
                "peso=" + peso +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", possuiCarreta=" + possuiCarreta +
                '}';
    }
}
