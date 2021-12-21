package br.com.techdive.exercicio1.domain;

public class Chefe extends Pessoa implements ComandoChefe{

    public Chefe(String nome, String cpf) {
        super(nome, cpf);
    }

    public void comandarEquipe() {
        System.out.println("Comandando equipe.");
    }

    @Override
    public String getComando() {
        return null;
    }
}
