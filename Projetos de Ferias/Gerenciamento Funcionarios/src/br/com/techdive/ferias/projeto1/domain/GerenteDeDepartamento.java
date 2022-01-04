package br.com.techdive.ferias.projeto1.domain;

import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class GerenteDeDepartamento extends Funcionario{


    public GerenteDeDepartamento(String nome, String sobrenome, String cpf, double salario) {
        super(nome, sobrenome, cpf, salario);
    }

    public GerenteDeDepartamento(String nome, String sobrenome, String cpf, double salario, Equipe equipe) {
        super(nome, sobrenome, cpf, salario);
        this.setEquipe(equipe);
    }

    public GerenteDeDepartamento(FuncionarioRequest funcionarioRequest) {
        super(funcionarioRequest);
    }
}
