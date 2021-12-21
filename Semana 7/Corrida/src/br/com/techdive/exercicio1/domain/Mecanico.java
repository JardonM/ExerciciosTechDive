package br.com.techdive.exercicio1.domain;

public class Mecanico extends Pessoa{

    private String especialidade;

    public Mecanico(String nome, String cpf, String especialidade) {
        super(nome, cpf);
        this.especialidade = especialidade;
    }

    public void ajusta() {
        System.out.println("Ajustando");
    }

    public void conserta() {
        System.out.println("Consertando");
    }


}
