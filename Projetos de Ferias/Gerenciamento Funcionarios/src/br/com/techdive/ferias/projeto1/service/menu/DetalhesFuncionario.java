package br.com.techdive.ferias.projeto1.service.menu;

import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.service.PesquisaFuncionario;
import br.com.techdive.ferias.projeto1.service.Teclado;


public class DetalhesFuncionario {


    public static void verDetalhesFuncionario() {
        Funcionario funcionarioEncontrado = PesquisaFuncionario.pesquisaFuncionario();
        System.out.println(funcionarioEncontrado.toString());
    }
}
