package br.com.techdive.ex5;

import br.com.techdive.ex3.Empregado;

public class Operario extends Empregado {

    private double valorProducao;
    private double comissao;

    public Operario(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double imposto, double comissao, double valorProducao) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        this.comissao = comissao;
        this.valorProducao = valorProducao;
    }


    public double calcularSalario() {
        double valorComissao = this.valorProducao * this.comissao;
        double salarioComComissao = getSalarioBase() + valorComissao;
        double valorImposto = salarioComComissao * getImposto();
        return salarioComComissao - valorImposto;
    }

    public double getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(double valorProducao) {
        this.valorProducao = valorProducao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}
