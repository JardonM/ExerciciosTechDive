package br.com.techdive.jogo.domain.personagens.inimigo;

import br.com.techdive.jogo.domain.enums.Arma;

public class Armeiro extends Inimigo{

    public Armeiro() {
        super(100, 10, 15, Arma.ESPADA);
    }

}
