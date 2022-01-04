package br.com.techdive.ferias.projeto1.domain;

import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class GerenteGeral extends Funcionario{

    public GerenteGeral(String nome, String sobrenome, String cpf, double salario) {
        super(nome, sobrenome, cpf, salario);
    }

    public GerenteGeral(String nome, String sobrenome, String cpf, double salario, Equipe equipe) {
        super(nome, sobrenome, cpf, salario);
        this.setEquipe(equipe);
    }

    public GerenteGeral(FuncionarioRequest funcionarioRequest) {
        super(funcionarioRequest);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome = '" + this.getNome() + '\'' +
                ", sobrenome = '" + this.getSobrenome() + '\'' +
                ", cpf = '" + this.getCpf() + '\'' +
                ", salario = " + this.getSalario() +
                '}';
    }
}
