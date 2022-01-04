package br.com.techdive.ferias.projeto1.service;

import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;

public class PesquisaFuncionario {

    public static Funcionario pesquisaFuncionario() {
        Funcionario funcionario = null;
        Teclado lerTeclado = new Teclado();
        while (funcionario == null) {
            String cpf = lerTeclado.lerString("CPF: ");
            funcionario = FuncionarioRepository.funcionariosAtivos.stream().filter(e -> e.getCpf().equals(cpf)).findFirst().orElse(null);
            if(funcionario == null) {
                System.out.println("Funcionario não encontrado!");
            }
        }
        return funcionario;
    }
}
