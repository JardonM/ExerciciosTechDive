package br.com.techdive.ex4;

public class Main {
    public static void main(String[] args) {

        Administrador administrador = new Administrador("Administrador teste", "Rua teste", "telefone teste", 8, 5000, 0.2, 1500);

        System.out.println(administrador.calcularSalario());

    }
}
