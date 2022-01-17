package br.com.techdive.jogo.domain.personagens.inimigo;

import br.com.techdive.jogo.domain.enums.Arma;

public class Lider extends Inimigo{
    public Lider() {
        super(200, 15, 15, Arma.MACHADO_DUPLO);
    }
}
