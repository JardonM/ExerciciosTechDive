package br.com.techdive.ex5;

public class Main {
    public static void main(String[] args) {

        Operario operario = new Operario("Operario teste", "Rua teste", "telefone teste", 19, 2000, 0.15, 0.1, 15000);
        System.out.println(operario.calcularSalario());
    }
}
