package br.com.techdive.ferias.projeto1.domain;

import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class LiderTecnico extends Funcionario{

    public LiderTecnico(String nome, String sobrenome, String cpf, double salario) {
        super(nome, sobrenome, cpf, salario);
    }

    public LiderTecnico(String nome, String sobrenome, String cpf, double salario, Equipe equipe) {
        super(nome, sobrenome, cpf, salario);
        this.setEquipe(equipe);
    }

    public LiderTecnico(FuncionarioRequest funcionarioRequest) {
        super(funcionarioRequest);
    }
}
