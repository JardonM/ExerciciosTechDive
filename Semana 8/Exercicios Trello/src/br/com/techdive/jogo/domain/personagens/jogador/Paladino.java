package br.com.techdive.jogo.domain.personagens.jogador;

import br.com.techdive.jogo.domain.enums.Arma;
import br.com.techdive.jogo.domain.enums.Motivacao;

public class Paladino extends Jogador{
    public Paladino(String nome, String sexo, Arma arma) {
        super(nome, sexo, arma, 13, 18);
    }
}
