package br.com.techdive.banco.service;

import br.com.techdive.banco.domain.*;

public class CriarContaCorrente implements CriarConta{

    @Override
    public Conta criarConta() {
        CadastroContaRequest contaRequest = new CadastroContaRequest();
        contaRequest = contaRequest.cadastrarDadosConta();
        double chequeEspecial = (contaRequest.getRendaMensal() * 12) * 0.2;

        ContaCorrente novaConta = new ContaCorrente(contaRequest.getNome(), contaRequest.getCpf(), contaRequest.getRendaMensal(), contaRequest.getAgencia(), contaRequest.getSaldo(), chequeEspecial);
        Banco.contas.add(novaConta);
        return novaConta;
    }
}
