package br.com.techdive.ferias.projeto1.service.menu;

import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;
import br.com.techdive.ferias.projeto1.service.PesquisaFuncionario;
import br.com.techdive.ferias.projeto1.service.Teclado;


public class DemitirFuncionario {


    public static void demitirFuncionario() {
        Teclado lerTeclado = new Teclado();
        Funcionario funcionarioASerDemitido = PesquisaFuncionario.pesquisaFuncionario();
        System.out.print("DESEJA REALMENTE DEMITIR O FUNCIONARIO ");
        System.out.print(funcionarioASerDemitido.getNome() + " " + funcionarioASerDemitido.getSobrenome() + "?");
        String opcao = lerTeclado.lerString("(s/n): ");
        if(opcao.equals("s")) {
            FuncionarioRepository.funcionariosAtivos.remove(funcionarioASerDemitido);
            FuncionarioRepository.funcionariosDemitidos.add(funcionarioASerDemitido);
        }
    }
}
