package br.com.techdive.ferias.projeto1.request;

import br.com.techdive.ferias.projeto1.domain.Funcionario;


public class FuncionarioRequest extends Funcionario {

    public FuncionarioRequest(String nome, String sobrenome, String cpf,  double salario) {
        super(nome, sobrenome, cpf, salario);
    }

    public FuncionarioRequest() {
    }
}
