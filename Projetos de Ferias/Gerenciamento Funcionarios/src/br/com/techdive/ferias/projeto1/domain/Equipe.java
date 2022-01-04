package br.com.techdive.ferias.projeto1.domain;

import java.util.List;

public class Equipe {
    private String nome;
    protected List<Funcionario> funcionarios;

    public Equipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
