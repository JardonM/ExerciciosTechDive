package br.com.jardon.domain;

public class Aviao extends Veiculo {

    private int asa;
    private int turbina;
    private boolean possuiBanheiro;
    private int helice;
    private boolean possuiSaidaEmergencia;
    private boolean possuiTremDePouso;


    public Aviao(String nome, String marca, boolean estaLigado, String cor, int lugares, int asa, int turbina, boolean possuiBanheiro, boolean possuiSaidaEmergencia, boolean possuiTremDePouso) {
        super(nome, marca, estaLigado, cor, lugares);
        this.asa = asa;
        this.turbina = turbina;
        this.possuiBanheiro = possuiBanheiro;
        this.possuiSaidaEmergencia = possuiSaidaEmergencia;
        this.possuiTremDePouso = possuiTremDePouso;
    }

    public Aviao(String nome, String marca, boolean estaLigado, String cor, int lugares ,int asa, boolean possuiBanheiro, int helice, boolean possuiSaidaEmergencia, boolean possuiTremDePouso) {
        super(nome, marca, estaLigado, cor, lugares);
        this.asa = asa;
        this.possuiBanheiro = possuiBanheiro;
        this.helice = helice;
        this.possuiSaidaEmergencia = possuiSaidaEmergencia;
        this.possuiTremDePouso = possuiTremDePouso;
    }

}
