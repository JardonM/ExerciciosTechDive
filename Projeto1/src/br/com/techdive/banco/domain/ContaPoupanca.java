package br.com.techdive.banco.domain;

public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(String nome, String cpf, double rendaMensal, Agencia agencia, double saldo, double rendimento) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        this.rendimento = rendimento;
    }

    public double calcularRendimento(int meses) {
        return ((getRendaMensal() * 12) * 0.15) / meses;
    }



}
