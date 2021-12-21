package br.com.techdive.ex6;

public class Main {

    public static void main(String[] args) {

        Vendedor vendedor = new Vendedor("vendedor teste", "rua teste", "telefone teste", 250, 1500, 0.15, 0.1, 30000);
        System.out.println(vendedor.calcularSalario());

    }
}
