package br.com.techdive.ex3;

public class Main {
    public static void main(String[] args) {

        Empregado empregado = new Empregado("Empregado Teste", "Rua teste", "telefone teste", 5, 3000, 0.2);
        System.out.println(empregado.calcularSalario());

    }
}
