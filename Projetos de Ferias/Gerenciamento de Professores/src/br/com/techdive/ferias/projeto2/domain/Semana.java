package br.com.techdive.ferias.projeto2.domain;


public class Semana {

    private Docente escala1;

    private Docente escala2;

    private String assunto;

    public Docente getEscala1() {
        return escala1;
    }

    public Docente getEscala2() {
        return escala2;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setEscala1(Docente escala1) {
        this.escala1 = escala1;
    }

    public void setEscala2(Docente escala2) {
        this.escala2 = escala2;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
