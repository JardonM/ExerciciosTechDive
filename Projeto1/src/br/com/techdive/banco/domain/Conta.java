package br.com.techdive.banco.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public abstract class Conta {

    private String nome;
    private String cpf;
    private double rendaMensal;
    private Integer numeroConta;
    private Agencia agencia;
    private double saldo;
    public List<HistoricoTransacoes> registros;

    public Conta(String nome, String cpf, double rendaMensal, Agencia agencia, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;
        this.saldo = saldo;
        this.registros = new ArrayList<>();
        this.numeroConta = Banco.contas.size()+1;
    }

    public void sacar(double valor) {
        if(this.saldo < valor) {
            System.out.println("Saldo insuficiente.");
        } else {
            this.saldo -= valor;
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void salvarRegistro(HistoricoTransacoes historico) {
        this.registros.add(historico);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void extrato() {
        System.out.println(this.registros);
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", numeroConta=" + numeroConta +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }
}
