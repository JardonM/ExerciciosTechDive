package domain;

import exception.LimiteInsuficienteException;


public class ContaEspecial extends ContaBancaria {

    private float limite;

    public ContaEspecial(String cliente, int numeroConta, float saldo, float limite) {
        super(cliente, numeroConta, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(float valor) {
        verificarLimite(valor);
        this.saldo -= valor;
        System.out.printf("Saque de R$%.2f efetuado com sucesso!", valor);
    }

    private void verificarLimite(float valor) {
        float valorAposSaque = this.saldo - valor;
        if(valorAposSaque < limite) {
            throw new LimiteInsuficienteException();
        }
    }


    public void extrato() {
        System.out.println("ContaEspecial{" +
                "cliente='" + this.cliente + '\'' +
                ", numeroConta=" + this.numeroConta +
                ", saldo=R$" + this.saldo +
                ", limite=R$" + this.limite +
                '}');
    }
}
