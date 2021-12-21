package br.com.techdive.exerc2.domain;

public class Destinatario extends Usuario implements Receptor{


    public Destinatario(String nome, String email) {
        super(nome, email);
    }


    @Override
    public void recebeMensagem() {

    }


}
