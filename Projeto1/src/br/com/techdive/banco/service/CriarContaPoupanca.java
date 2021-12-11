package br.com.techdive.banco.service;


import br.com.techdive.banco.domain.Banco;
import br.com.techdive.banco.domain.Conta;
import br.com.techdive.banco.domain.ContaPoupanca;


public class CriarContaPoupanca implements CriarConta {

    @Override
    public Conta criarConta() {
        CadastroContaRequest contaRequest = new CadastroContaRequest();
        contaRequest = contaRequest.cadastrarDadosConta();
        ContaPoupanca novaConta = new ContaPoupanca(contaRequest.getNome(), contaRequest.getCpf(), contaRequest.getRendaMensal(), contaRequest.getAgencia(), contaRequest.getSaldo(), 1.5);
        Banco.contas.add(novaConta);
        return novaConta;
    }



}
