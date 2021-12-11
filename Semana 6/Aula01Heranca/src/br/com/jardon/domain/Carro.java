package br.com.jardon.domain;



public class Carro extends Veiculo{

    private int numPortas;
    private double motorizacao;


    public Carro(String nome, String marca, boolean estaLigado, String cor, int lugares, int numPortas, double motorizacao) {
        super(nome, marca, estaLigado, cor, lugares);
        this.numPortas = numPortas;
        this.motorizacao = motorizacao;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome=" + getNome() +
                ", marca=" + getMarca() +
                ", estaLigado=" + isEstaLigado() +
                ", cor=" + getCor() +
                ", lugares=" + getLugares() +
                ", numPortas=" + numPortas +
                ", motorizacao=" + motorizacao +
                '}';
    }
}
