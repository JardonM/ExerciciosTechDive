package br.com.techdive.jogo.domain.personagens.inimigo;

import br.com.techdive.jogo.domain.Atacante;
import br.com.techdive.jogo.domain.enums.Arma;
import br.com.techdive.jogo.domain.personagens.Personagem;

import java.util.Random;

public abstract class Inimigo extends Personagem implements Atacante {

    private Arma arma;

    public Inimigo(int saude, int pontosAtq, int pontosDef, Arma arma) {
        super(saude, pontosAtq, pontosDef);
        this.arma = arma;
    }

    @Override
    public void atacar(Personagem jogador) {
        Random random = new Random();
        int dado = random.nextInt(21);
        int ataqueInimigo = this.getPontosAtq() + this.getArma().getValue() + dado;
        if (dado == 1) {
            System.out.println("o inimigo errou o ataque! Voce nao sofreu dano.");
        } else if (dado == 20) {
            jogador.setSaude(jogador.getSaude() - ataqueInimigo);
            System.out.println("O inimigo acertou um ataque critico! Você sofreu " + ataqueInimigo + " de dano e agora possui " + jogador.getSaude() + " pontos de vida.");
        } else {
            int dano =  ataqueInimigo - jogador.getPontosDef();
            if (dano > 0) {
                jogador.setSaude(jogador.getSaude() - dano);
                System.out.println("O inimigo atacou! Você sofreu " + dano + " de dano e agora possui " + jogador.getSaude() + " pontos de vida.");
            }
        }
    }

    public Arma getArma() {
        return arma;
    }
}
