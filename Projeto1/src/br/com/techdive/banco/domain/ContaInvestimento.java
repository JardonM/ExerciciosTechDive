package br.com.techdive.banco.domain;


public class ContaInvestimento extends Conta{

    private Investimento investimento;

    public ContaInvestimento(String nome, String cpf, double rendaMensal, Agencia agencia, double saldo, Investimento investimento) {
        super(nome, cpf, rendaMensal, agencia, saldo);
        this.investimento = investimento;
    }

    public double calcularInvestimento(double valor) {
        double lucro = 0;
        if(investimento.equals(Investimento.IMOBILARIO)) {
            lucro = (valor * 0.2);
        } else if (investimento.equals(Investimento.CORPORATIVO)) {
            lucro = (valor * 0.3);
        } else if (investimento.equals(Investimento.CRYPTO)) {
            lucro = (valor * 0.4);
        }
        return lucro;
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }
}
