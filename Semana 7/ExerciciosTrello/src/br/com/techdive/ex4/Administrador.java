package br.com.techdive.ex4;


import br.com.techdive.ex3.Empregado;

public class Administrador extends Empregado {
    private double ajudaDeCusto;


    public Administrador(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double imposto, double ajudaDeCusto) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public double calcularSalario() {
        double valorImposto = getSalarioBase() * getImposto();
        return getSalarioBase() - valorImposto + this.ajudaDeCusto;
    }

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }
}
