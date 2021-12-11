package br.com.techdive.banco.domain;

public class ContaCorrente extends Conta{

    private double chequeEspecial;

    public ContaCorrente(String nome, String cpf, double rendaMensal, Agencia agencia, double saldo, double chequeEspecial) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public double calcularChequeEspecial() {
        return (getRendaMensal() * 12) * 0.2;
    }

    @Override
    public void sacar(double valor) {
        double saldoNegativo = this.getSaldo() - valor;
        if (saldoNegativo < chequeEspecial) {
            System.out.println("Saldo insuficiente.");
        } else {
            setSaldo(getSaldo() - valor);
        }
    }




}
