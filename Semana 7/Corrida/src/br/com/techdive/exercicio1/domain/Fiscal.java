package br.com.techdive.exercicio1.domain;

public class Fiscal extends Pessoa{



    public Fiscal(String nome, String cpf) {
        super(nome, cpf);
    }


    public void fiscaliza() {
        System.out.println("Fiscalizando");
    }

    public void balancaBandeira() {
        System.out.println("Balancando bandeira");
    }

    public void contaVolta(Carro carro) {
        carro.voltas += 1;
        System.out.println("Contando a volta de um carro especifico");
    }
}
