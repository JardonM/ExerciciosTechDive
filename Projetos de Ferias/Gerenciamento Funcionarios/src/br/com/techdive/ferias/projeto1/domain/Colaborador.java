package br.com.techdive.ferias.projeto1.domain;

import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class Colaborador extends Funcionario{

    public Colaborador(String nome, String sobrenome, String cpf, double salario) {
        super(nome, sobrenome, cpf, salario);
    }

    public Colaborador(String nome, String sobrenome, String cpf, double salario, Equipe equipe) {
        super(nome, sobrenome, cpf, salario);
        this.setEquipe(equipe);
    }

    public Colaborador(FuncionarioRequest funcionarioRequest) {
        super(funcionarioRequest);
    }
}
