package br.com.jardon.domain;




public class Veiculo {

    private String nome;
    private String marca;
    private boolean estaLigado;
    private String cor;
    private int lugares;

    public Veiculo(String nome, String marca, boolean estaLigado, String cor, int lugares) {
        this.nome = nome;
        this.marca = marca;
        this.estaLigado = estaLigado;
        this.cor = cor;
        this.lugares = lugares;
    }

    public void ligarVeiculo() {
        if(this.estaLigado){
            System.out.println("Veiculo já está ligado.");
        } else {
            this.estaLigado = true;
        }
    }

    public void desligarVeiculo() {
        if (!this.estaLigado){
            System.out.println("Veiculo já está desligado");
        } else{
            this.estaLigado = false;
        }
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", estaLigado=" + estaLigado +
                ", cor='" + cor + '\'' +
                '}';
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isEstaLigado() {
        return estaLigado;
    }

    public void setEstaLigado(boolean estaLigado) {
        this.estaLigado = estaLigado;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }
}
