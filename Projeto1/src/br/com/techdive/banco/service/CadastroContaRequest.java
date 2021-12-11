package br.com.techdive.banco.service;

import br.com.techdive.banco.domain.Agencia;

public class CadastroContaRequest {

    private Teclado teclado = new Teclado();
    private String nome;
    private String cpf;
    private double rendaMensal;
    private Agencia agencia;
    private double saldo;

    public CadastroContaRequest cadastrarDadosConta() {
        CadastroContaRequest contaRequest = new CadastroContaRequest();
        System.out.println("--- CADASTRO DE CONTA ---");
        contaRequest.nome = teclado.lerString("Digite seu nome: ");
        contaRequest.cpf = teclado.lerString("Digite seu CPF(apenas numeros, 11 digitos): ");
        verificaCpf(contaRequest);
        contaRequest.rendaMensal = teclado.lerDouble("Qual é sua Renda Mensal: ");
        int codAgencia = teclado.lerInteger("Deseja vincular sua conta a qual Agencia? \n001 - Florianopolis\n002 - Sao Jose\n");
        contaRequest.agencia = Agencia.SEM_AGENCIA;
        if(codAgencia == 001) {
            contaRequest.agencia = Agencia.FLORIANOPOLIS;
        } else if (codAgencia == 002) {
            contaRequest.agencia = Agencia.SAO_JOSE;
        } else {
            System.out.println("Agencia invalida! Favor atualizar os dados cadastrais para vincular sua conta a uma Agencia!");
        }
        contaRequest.saldo = 0;
        String confirmacaoDepositoInicial = teclado.lerString("Deseja fazer um deposito inicial? (s/n)");
        if(confirmacaoDepositoInicial.equals("s")) {
            contaRequest.saldo = teclado.lerInteger("Qual valor deseja depositar? R$");
        }
        return contaRequest;
    }


    private void verificaCpf(CadastroContaRequest contaRequest) {
        if(contaRequest.cpf.length() != 11) {
            contaRequest.cpf = teclado.lerString("CPF inválido, por favor digite um CPF  válido: ");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }
}
