import domain.ContaEspecial;
import domain.ContaPoupanca;

public class Contas {

    public static void main(String[] args) {

        ContaPoupanca contaPoupanca = new ContaPoupanca("Cliente Poupanca", 102030, 2000, 0.01);
        ContaEspecial contaEspecial = new ContaEspecial("Cliente Especial", 101020, 10000, -20000);

        contaPoupanca.sacar(200);
        contaPoupanca.extrato();
        contaPoupanca.depositar(3000);
        contaPoupanca.extrato();
        contaPoupanca.calcularNovoSaldo();
        contaPoupanca.extrato();

        contaEspecial.sacar(25000);
        contaEspecial.extrato();
        contaEspecial.depositar(5000);
        contaEspecial.extrato();


    }

}
