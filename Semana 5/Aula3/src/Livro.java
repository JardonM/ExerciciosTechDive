

public class Livro {

    private String titulo;
    private int paginas;
    private String fabricante;

    public Livro(String titulo, int paginas, String fabricante) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.fabricante = fabricante;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public String getFabricante() {
        return this.fabricante;
    }


}
