package br.com.techdive.banco.service;

import br.com.techdive.banco.domain.*;
import jdk.swing.interop.SwingInterOpUtils;


import javax.imageio.plugins.tiff.TIFFDirectory;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ContaService {

    Teclado teclado = new Teclado();


    public void criarConta() {
        HashMap<Integer, CriarConta> criarContaMap = new HashMap<>();
        criarContaMap.put(1, new CriarContaPoupanca());
        criarContaMap.put(2, new CriarContaCorrente());
        criarContaMap.put(3, new CriarContaInvestimento());
        System.out.println("--- CADASTRO DE CONTAS ---");
        System.out.println("Selecione qual tipo de conta deseja criar: ");
        System.out.println("1 -- Conta Poupanca");
        System.out.println("2 -- Conta Corrente");
        System.out.println("3 -- Conta Investimento");
        int tipoConta = teclado.lerInteger("Digite aqui: ");
        CriarConta retornoMap = criarContaMap.get(tipoConta);
        if(retornoMap != null) {
            Conta novaConta = retornoMap.criarConta();
            System.out.println("Conta criada com sucesso!");
        } else {
            System.out.println("Opcao invalida!");
        }

    }

    public void menuOpcoes() {
        String saidaMenu = "n";
        while (!saidaMenu.equals("s")){
            System.out.println("---- TECH-DIVE SENAI ----");
            System.out.println("SEJA BEM VINDO AO BANCO TECHDIVE!");
            System.out.println("Selecione a opcao desejada: ");
            System.out.println("1 --- CRIAR CONTA");
            System.out.println("2 --- ACESSAR CONTA");
            int opcaoMenu = teclado.lerInteger("Digite aqui: ");
            if(opcaoMenu == 1) {
                criarConta();
            } else if(opcaoMenu == 2) {
                acessarConta();
            }
            saidaMenu = teclado.lerString("Deseja sair da aplicacao? (s/n)");
        }

    }

    private void acessarConta() {
        String opcaoSair = "n";
        while (!opcaoSair.equals("s")) {
            String nome = teclado.lerString("Digite seu nome: ");
            String cpf = teclado.lerString("Digite seu CPF: ");
            List<Conta> conta = Banco.contas.stream().filter(e -> e.getNome().equals(nome) && e.getCpf().equals(cpf)).collect(Collectors.toList());
            if(conta.isEmpty()){
                System.out.println("Conta inexistente!");
            } else {
                opcaoSair = "s";
                menuConta(conta.get(0));
            }
        }

    }

    private void menuConta(Conta conta){
        String opcaoSair = "n";
        while (!opcaoSair.equals("s")){

            System.out.println("Seja bem vindo " + conta.getNome() + "!");
            System.out.println("Deseja efetuar qual operacao: ");
            System.out.println("1 --- DEPOSITAR");
            System.out.println("2 --- SACAR");
            System.out.println("3 --- TRANSFERIR");
            if(conta.getClass().equals(ContaPoupanca.class)){
                System.out.println("4 --- SIMULAR RENDIMENTO");
            }
            if(conta.getClass().equals(ContaCorrente.class)){
                System.out.println("4 --- VER CHEQUE ESPECIAL");
            }
            if(conta.getClass().equals(ContaInvestimento.class)){
                System.out.println("4 --- INVESTIR");
            }
            System.out.println("5 --- ATUALIZAR DADOS CADASTRAIS");
            System.out.println("6 --- EXTRATO");
            System.out.println("7 --- VER SALDO");
            System.out.println("8 --- SAIR");
            int opcaoMenuConta = teclado.lerInteger("Digite aqui: ");

            switch (opcaoMenuConta) {
                case 1 -> {
                    double valor = teclado.lerDouble("Quanto deseja depositar? R$");
                    conta.depositar(valor);
                    conta.registros.add(new HistoricoTransacoes(TipoTransacao.DEPOSITO, conta.getNumeroConta(), valor, LocalDateTime.now()));
                    System.out.println("Saldo atualizado: " + conta.getSaldo());
                }
                case 2 -> {
                    double valor = teclado.lerDouble("Quanto deseja sacar? R$");
                    conta.sacar(valor);
                    conta.registros.add(new HistoricoTransacoes(TipoTransacao.SAQUE, conta.getNumeroConta(), valor, LocalDateTime.now()));
                }
                case 3 -> {
                    int numeroContaDestino = teclado.lerInteger("Digite o numero da conta destino para transferir: ");
                    double valorTransferencia = teclado.lerDouble("Digite o valor que deseja transferir: R$");
                    List<Conta> contaDestino = Banco.contas.stream().filter(e -> e.getNumeroConta().equals(numeroContaDestino)).collect(Collectors.toList());
                    transferencia(conta, contaDestino.get(0), valorTransferencia);
                }
                case 4 -> {
                    if(conta.getClass().equals(ContaPoupanca.class)){
                        int meses = teclado.lerInteger("Quantos meses deseja calcular? ");
                        System.out.println("Rendimento será de: " + ((ContaPoupanca) conta).calcularRendimento(meses));
                    }
                    if(conta.getClass().equals(ContaCorrente.class)){
                        System.out.println(((ContaCorrente) conta).calcularChequeEspecial());
                    }
                    if(conta.getClass().equals(ContaInvestimento.class)){
                        String opcaoInvestimento = teclado.lerString("Deseja trocar o setor de investimento? (s/n)");
                        if (((ContaInvestimento) conta).getInvestimento().equals(Investimento.NAO_ESCOLHIDO) || (opcaoInvestimento.equals("s"))) {
                            System.out.println("Você precisa escolher onde investir!");
                            System.out.print("1 --- IMOBILIARIO - 20%/ano\n2 --- CRYPTO - 30%/ano \n3 --- CORPORATIVO - 40%/ano");
                            int opcao = teclado.lerInteger("Digite aqui: ");
                            if(opcao == 1) {
                                ((ContaInvestimento) conta).setInvestimento(Investimento.IMOBILARIO);
                            }
                            if(opcao == 2) {
                                ((ContaInvestimento) conta).setInvestimento(Investimento.CRYPTO);
                            }
                            if(opcao == 3) {
                                ((ContaInvestimento) conta).setInvestimento(Investimento.CORPORATIVO);
                            }
                        }
                        double valorInvestimento = teclado.lerDouble("Digite o valor para investimento: ");
                        double lucro = ((ContaInvestimento) conta).calcularInvestimento(valorInvestimento);
                        System.out.println("Seu lucro de investimento: " + lucro);
                        conta.depositar(lucro);
                        conta.registros.add(new HistoricoTransacoes(TipoTransacao.INVESTIMENTO, conta.getNumeroConta(), lucro, LocalDateTime.now()));
                    }
                }
                case 5 -> {
                    atualizarDados(conta);
                }
                case 6 -> {
                    System.out.println(conta.registros);
                }
                case 7 -> {
                    System.out.println("Seu saldo é de: " + conta.getSaldo());
                }
            }
            if(opcaoMenuConta == 8) {
                opcaoSair = "s";
            } else {
                opcaoSair = teclado.lerString("Deseja sair da conta? (s/n)");
            }
        }

    }

    private void transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
        contaOrigem.registros.add(new HistoricoTransacoes(TipoTransacao.TRANSFERENCIA, contaOrigem.getNumeroConta(), contaDestino.getNumeroConta(), valor, LocalDateTime.now()));
        contaDestino.registros.add(new HistoricoTransacoes(TipoTransacao.TRANSFERENCIA, contaOrigem.getNumeroConta(), contaDestino.getNumeroConta(), valor, LocalDateTime.now()));
    }


    public void atualizarDados(Conta conta) {
        String opcaoMenuAtualizar = "";
        while(!Objects.equals(opcaoMenuAtualizar, "n")) {
            System.out.println("---- ATUALIZACAO DE DADOS CADASTRAIS ----");
            System.out.println("    Selecione a opcao desejada: ");
            System.out.println("1 -- Nome");
            System.out.println("2 -- Renda Mensal");
            System.out.println("3 -- Agencia");
            System.out.println("4 -- Voltar");
            int opcaoSelecionada = teclado.lerInteger("Digite aqui: ");
            String letraConfirmacao = "";

            switch (opcaoSelecionada) {
                case 1 -> {
                    while (!letraConfirmacao.equals("s")) {
                        String novoNome = teclado.lerString("Digite seu nome: ");
                        letraConfirmacao = teclado.lerString("Deseja atualizar NOME para: " + novoNome + "? (s/n)");
                        if (letraConfirmacao.equals("s")) {
                            conta.setNome(novoNome);
                        }
                    }
                    System.out.println("Nome atualizado para " + conta.getNome() + " com sucesso!");
                }
                case 2 -> {
                    double novaRenda = 0;
                    while (!letraConfirmacao.equals("s")) {
                        novaRenda = teclado.lerInteger("Digite sua nova renda: R$");
                        letraConfirmacao = teclado.lerString("Deseja atualizar Renda Mensal para: R$" + novaRenda + "? (s/n)");
                        if (letraConfirmacao.equals("s")) {
                            conta.setRendaMensal(novaRenda);
                        }
                    }
                    System.out.println("Renda Mensal atualizada para R$" + conta.getRendaMensal() + " com sucesso!");
                }
                case 3 -> {
                    while (!letraConfirmacao.equals("s")) {
                        int novaAgencia = teclado.lerInteger("Digite o numero de sua nova Agencia: ");
                        if (novaAgencia == 001) {
                            letraConfirmacao = teclado.lerString("Deseja atualizar sua Agencia para: " + Agencia.FLORIANOPOLIS.getAgencia() + "? (s/n)");
                            if (letraConfirmacao.equals("s")) {
                                conta.setAgencia(Agencia.FLORIANOPOLIS);
                            }
                        }
                        if (novaAgencia == 002) {
                            letraConfirmacao = teclado.lerString("Deseja atualizar sua Agencia para: " + Agencia.SAO_JOSE.getAgencia() + "? (s/n)");
                            if (letraConfirmacao.equals("s")) {
                                conta.setAgencia(Agencia.SAO_JOSE);
                            }
                        }
                    }
                    System.out.println("Agencia atualizada para " + conta.getAgencia().getAgencia() + " com sucesso!");
                }
                case 4 -> {
                    System.out.println("Redirecionando a pagina anterior...");
                    opcaoMenuAtualizar = "n";
                }

            }
            if(opcaoSelecionada != 4) {
                conta.salvarRegistro(new HistoricoTransacoes(TipoTransacao.ATUALIZACAO_DADOS_CADASTRAIS, conta.getNumeroConta(), LocalDateTime.now()));
                opcaoMenuAtualizar = teclado.lerString("Deseja atualizar outro dado cadastral? (s/n)");
            }

        }

    }


}
