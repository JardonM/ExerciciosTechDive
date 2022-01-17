package br.com.techdive.jogo.domain.personagens.jogador;

import br.com.techdive.jogo.domain.enums.Arma;
import br.com.techdive.jogo.domain.enums.Motivacao;

public class Mago extends Jogador{
    public Mago(String nome, String sexo, Arma arma) {
        super(nome, sexo, arma, 19, 11);
    }
}
