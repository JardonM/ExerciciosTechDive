package domain;

public class ContaPoupanca extends ContaBancaria {

    private double rendimentoDiario;

    public ContaPoupanca(String cliente, int numeroConta, float saldo, double rendimentoDiario) {
        super(cliente, numeroConta, saldo);
        this.rendimentoDiario = rendimentoDiario;
    }

    public void calcularNovoSaldo() {
        float valor = (float) (this.saldo * rendimentoDiario);
        this.saldo += valor;
        System.out.printf("Deposito de R$%.2f devido ao rendimento diario da Conta Poupanca.", valor);
    }


    public void extrato() {
        System.out.println("ContaPoupanca{" +
                "cliente='" + this.cliente + '\'' +
                ", numeroConta=" + this.numeroConta +
                ", saldo=" + this.saldo +
                ", rendimentoDiario=" + this.rendimentoDiario +
                '}');
    }
}
