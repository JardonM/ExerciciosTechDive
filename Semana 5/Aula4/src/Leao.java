

public class Leao {

    private String nome;
    private double peso;
    public static int totalLeoes;

    public Leao(String nome) {
        totalLeoes++;
        this.nome = nome;
    }

    public void rugir() {
        System.out.println("Leao " + this.nome + " está rugindo.");
    }

}
