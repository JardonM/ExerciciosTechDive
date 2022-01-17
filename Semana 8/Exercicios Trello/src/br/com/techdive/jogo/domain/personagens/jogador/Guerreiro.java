package br.com.techdive.jogo.domain.personagens.jogador;

import br.com.techdive.jogo.domain.enums.Arma;
import br.com.techdive.jogo.domain.enums.Motivacao;

public class Guerreiro extends Jogador{
    public Guerreiro(String nome, String sexo, Arma arma) {
        super(nome, sexo, arma, 15, 15);
    }
}
