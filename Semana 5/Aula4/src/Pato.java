

public class Pato {

    private String nome;
    private double peso;
    public static int totalPatos;

    public Pato(String nome) {
        totalPatos++;
        this.nome = nome;
    }


    public void grasnar() {
        System.out.println("Pato " + this.nome + " está grasnando.");
    }
}
