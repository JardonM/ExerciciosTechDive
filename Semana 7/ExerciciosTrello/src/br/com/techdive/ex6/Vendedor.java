package br.com.techdive.ex6;

import br.com.techdive.ex3.Empregado;

public class Vendedor extends Empregado {

    private double valorVendas;
    private double comissao;

    public Vendedor(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double imposto, double comissao, double valorVendas) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        this.comissao = comissao;
        this.valorVendas = valorVendas;
    }

    @Override
    public double calcularSalario() {
        double valorComissao = this.valorVendas * this.comissao;
        double salarioComComissao = getSalarioBase() + valorComissao;
        double valorImposto = salarioComComissao * getImposto();
        return salarioComComissao - valorImposto;
    }

}
