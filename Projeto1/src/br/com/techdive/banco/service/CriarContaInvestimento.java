package br.com.techdive.banco.service;

import br.com.techdive.banco.domain.*;

public class CriarContaInvestimento implements CriarConta{

    private Teclado teclado = new Teclado();

    @Override
    public Conta criarConta() {
        CadastroContaRequest contaRequest = new CadastroContaRequest();
        contaRequest = contaRequest.cadastrarDadosConta();
        int opcaoInvestimento = teclado.lerInteger("Em qual ramo deseja investir?\n1 --- IMOBILIARIO - 20%/ano\n2 --- CRYPTO - 30%/ano \n3 --- CORPORATIVO - 40%/ano");
        Investimento investimento = Investimento.NAO_ESCOLHIDO;
        if(opcaoInvestimento == 1) {
            investimento = Investimento.IMOBILARIO;
        } else if(opcaoInvestimento == 2) {
            investimento = Investimento.CRYPTO;
        } else if(opcaoInvestimento == 3) {
            investimento = Investimento.CORPORATIVO;
        } else {
            System.out.println("Opcao invalida! Favor atualizar dados cadastrais!");
        }

        ContaInvestimento novaConta = new ContaInvestimento(contaRequest.getNome(), contaRequest.getCpf(), contaRequest.getRendaMensal(), contaRequest.getAgencia(), contaRequest.getSaldo(), investimento);
        Banco.contas.add(novaConta);
        return novaConta;
    }
}
