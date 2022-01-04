package br.com.techdive.ferias.projeto1.service;

import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class VerificarDadosFuncionario {

    public static boolean verificar(FuncionarioRequest funcionario) {
        return verificarNome(funcionario.getNome(), funcionario.getSobrenome()) && verificarCpf(funcionario.getCpf());
    }

    private static boolean verificarNome(String nome, String sobrenome) {
        boolean verificado = true;
        if(nome.isEmpty() || nome.isBlank()) {
            System.out.println("Nome não pode ser em branco!");
            verificado = false;
        }
        if(sobrenome.isEmpty() || sobrenome.isBlank()) {
            System.out.println("Sobrenome não pode ser em branco!");
            verificado = false;
        }
        return verificado;
    }

    private static boolean verificarCpf(String cpf) {
        boolean verificado = true;
        if(cpf.length() != 11) {
            System.out.println("CPF invalido!");
            verificado = false;
        }
        return verificado;
    }
}
