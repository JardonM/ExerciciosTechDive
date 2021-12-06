

public class Elefante {

    private String nome;
    private double peso;
    public static int totalElefantes;

    public Elefante(String nome) {
        totalElefantes++;
        this.nome = nome;
    }

    public void fazerBarulho() {
        System.out.println("Elefante " + this.nome + " está fazendo barulho.");
    }

}
