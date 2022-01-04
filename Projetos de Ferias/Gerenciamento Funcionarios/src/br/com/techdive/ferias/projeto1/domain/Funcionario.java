package br.com.techdive.ferias.projeto1.domain;


import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class Funcionario {

    private String nome;
    private String sobrenome;
    private String cpf;
    private double salario;
    private Equipe equipe;

    public Funcionario() {
    }

    public Funcionario(String nome, String sobrenome, String cpf,  double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public Funcionario(FuncionarioRequest funcionarioRequest) {
        this.nome = funcionarioRequest.getNome();
        this.sobrenome = funcionarioRequest.getSobrenome();
        this.cpf = funcionarioRequest.getCpf();
        this.salario = funcionarioRequest.getSalario();
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome = '" + nome + '\'' +
                ", sobrenome = '" + sobrenome + '\'' +
                ", cpf = '" + cpf + '\'' +
                ", salario = " + salario +
                ", equipe = " + equipe +
                ", cargo = " + this.getClass().getName().substring(39) +
                '}';
    }
}
