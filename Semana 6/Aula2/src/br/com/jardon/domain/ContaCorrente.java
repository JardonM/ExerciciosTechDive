package br.com.jardon.domain;

public class ContaCorrente {

    private int idConta;
    private double saldoConta;
    private double taxaSaque;

    public ContaCorrente(int idConta, double saldoConta) {
        this.idConta = idConta;
        this.saldoConta = saldoConta;
        this.taxaSaque = 5.5;
    }

    public void sacar(double valor) {
        if (this.saldoConta < valor + this.taxaSaque) {
            System.out.println("Saldo insuficiente.");
        } else {
            this.saldoConta -= valor - this.taxaSaque;
        }
    }

    public void depositar(double valor) {
        this.saldoConta += valor;
    }


    public void extrato() {
        System.out.println("ContaCorrente {" +
                "idConta = " + this.idConta +
                ", saldoConta = " + this.saldoConta +
                ", taxaSaque = " + this.taxaSaque +
                '}');
    }

    public void setTaxaSaque(double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }
}
