package br.com.techdive.jogo.domain.personagens;

public abstract class Personagem {
    private int saude;
    private int pontosAtq;
    private int pontosDef;

    public Personagem(int saude, int pontosAtq, int pontosDef) {
        this.saude = saude;
        this.pontosAtq = pontosAtq;
        this.pontosDef = pontosDef;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getPontosAtq() {
        return pontosAtq;
    }

    public void setPontosAtq(int pontosAtq) {
        this.pontosAtq = pontosAtq;
    }

    public int getPontosDef() {
        return pontosDef;
    }

    public void setPontosDef(int pontosDef) {
        this.pontosDef = pontosDef;
    }
}
