package domain;


import exception.SaqueInvalidoException;

public class ContaBancaria {

    protected String cliente;
    protected int numeroConta;
    protected float saldo;

    public ContaBancaria(String cliente, int numeroConta, float saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void sacar(float valor) {
        verificarSaldo(valor);
        this.saldo -= valor;
        System.out.printf("Saque de R$%.2f efetuado com sucesso!\n", valor);
    }

    private void verificarSaldo(float valor) {
        if(this.saldo < valor) {
            throw new SaqueInvalidoException();
        }

    }

    public void depositar(float valor) {
        this.saldo += valor;
        System.out.printf("Deposito de R$%.2f efetuado com sucesso!", valor);
    }

}
