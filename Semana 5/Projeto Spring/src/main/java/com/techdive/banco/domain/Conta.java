package com.techdive.banco.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conta {

    private String nome;
    private double saldo;
    Long numeroConta;

    public Conta(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

}
