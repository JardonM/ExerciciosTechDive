package br.com.techdive.banco;

import br.com.techdive.banco.domain.Agencia;
import br.com.techdive.banco.domain.Banco;
import br.com.techdive.banco.domain.ContaPoupanca;
import br.com.techdive.banco.service.ContaService;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        ContaService service = new ContaService();
//
//        ContaPoupanca contaPoupanca = new ContaPoupanca("testePoupanca", "00000000000", 2000, Agencia.FLORIANOPOLIS, 5000, 1.5);
//
//        System.out.println("Rendimento em 6 meses: " + contaPoupanca.calcularRendimento(6));
//
//        service.atualizarDados(contaPoupanca);
//
//        service.criarConta();

        service.menuOpcoes();

        System.out.println(Banco.contas.stream().filter(e -> e.getClass().equals(ContaPoupanca.class)).collect(Collectors.toList()));

    }

}
