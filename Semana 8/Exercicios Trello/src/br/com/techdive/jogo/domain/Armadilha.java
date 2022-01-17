package br.com.techdive.jogo.domain;

import br.com.techdive.jogo.domain.enums.Arma;
import br.com.techdive.jogo.domain.personagens.Personagem;

import java.util.Random;


public class Armadilha implements Atacante{

    private int pontosDeAtaque;
    private Arma arma;

    public Armadilha() {
        this.pontosDeAtaque = 5;
        this.arma = Arma.ARMADILHA;
    }

    @Override
    public void atacar(Personagem personagem) {
        Random random = new Random();
        int dado = random.nextInt(10);
        if(dado < 2) {
            System.out.println("O ataque da armadilha pegou de raspão e você não sofreu dano.");
        } else {
            int ataque = this.pontosDeAtaque + this.arma.getValue() + dado;
            personagem.setSaude(personagem.getSaude() - ataque);
            System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.", ataque, personagem.getSaude());
        }
    }
}
