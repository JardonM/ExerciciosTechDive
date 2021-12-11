package br.com.techdive.exercicios.ex1.domain;

public class Barco implements Transporte{

    private int peso;
    private String modelo;
    private String marca;

    public Barco(int peso, String modelo, String marca) {
        this.peso = peso;
        this.modelo = modelo;
        this.marca = marca;
    }

    public void entregar() {
        System.out.println("Entregue.");
    }

    @Override
    public int criarTransporte() {
        return 15;
    }


    @Override
    public String toString() {
        return "Barco{" +
                "peso=" + peso +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
