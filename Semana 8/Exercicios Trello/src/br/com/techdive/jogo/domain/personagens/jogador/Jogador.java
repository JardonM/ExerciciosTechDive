package br.com.techdive.jogo.domain.personagens.jogador;

import br.com.techdive.jogo.domain.Atacante;
import br.com.techdive.jogo.domain.enums.Arma;
import br.com.techdive.jogo.domain.enums.Motivacao;
import br.com.techdive.jogo.domain.personagens.Personagem;
import br.com.techdive.jogo.domain.personagens.inimigo.Inimigo;
import br.com.techdive.jogo.service.Teclado;

import java.util.Random;

public abstract class Jogador extends Personagem implements Atacante {

    private String nome;
    private String sexo;
    private Motivacao motivacao;
    private Arma arma;
    private Teclado teclado;


    public Jogador(String nome, String sexo,  Arma arma, int pontosAtq, int pontosDef) {
        super(200, pontosAtq, pontosDef);
        this.arma = arma;
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random random = new Random();
        int dado = random.nextInt(21);
        int ataqueJogador = this.getPontosAtq() + this.getArma().getValue() + dado;
        if (dado == 1) {
            System.out.println("Você errou seu ataque! O inimigo nao sofreu dano algum!");
        } else if (dado == 20) {
            inimigo.setSaude(inimigo.getSaude() - ataqueJogador);
            System.out.println("Você acertou um ataque critico!");
            System.out.println("Você atacou " + this.getArma().getFraseAtaque() + " e causou " + ataqueJogador + " de dano ao inimigo!");
        } else {
             int dano = ataqueJogador - inimigo.getPontosDef();
            if (dano > 0) {
                inimigo.setSaude(inimigo.getSaude() - dano);
                System.out.println("Você atacou " + this.getArma().getFraseAtaque() + " e causou " + dano + " de dano ao inimigo!");
            }
        }
    }


    public void setMotivacao(Motivacao motivacao) {
        this.motivacao = motivacao;
    }

    public Motivacao getMotivacao() {
        return motivacao;
    }

    public Arma getArma() {
        return arma;
    }

    public String getSexo() {
        return sexo;
    }
}
