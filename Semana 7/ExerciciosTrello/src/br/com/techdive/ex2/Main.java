package br.com.techdive.ex2;

public class Main {
    public static void main(String[] args) {

        Fornecedor fornecedor = new Fornecedor("Fornecedor Teste", "Rua de Testes", "telefone de testes", 5000, 2000);
        System.out.println(fornecedor.obterSaldo());
    }
}
