package br.com.techdive.exercicios.ex1.domain;

import java.util.ArrayList;
import java.util.List;

public class LogisticaTerrestre implements Logistica{

    private List<Transporte> transportes;

    public void criarTransporte(Transporte transporte) {
        if(this.transportes == null) {
            List<Transporte> novaLista = new ArrayList<>();
            this.transportes = novaLista;
        }
        this.transportes.add(transporte);
    }

    public void auditar() {
        System.out.println("Auditado.");
    }

    @Override
    public int planejarEntrega() {
        return 10;
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    @Override
    public String toString() {
        return "LogisticaTerrestre{" +
                "transportes=" + transportes +
                '}';
    }
}
