package br.com.techdive.exercicios.ex1;

import br.com.techdive.exercicios.ex1.domain.Barco;
import br.com.techdive.exercicios.ex1.domain.Caminhao;
import br.com.techdive.exercicios.ex1.domain.LogisticaAquatica;
import br.com.techdive.exercicios.ex1.domain.LogisticaTerrestre;

import java.util.stream.Collectors;

public class Operacao {

    public static void main(String[] args) {

        Barco barco1 = new Barco(500, "modeloBar1", "marcaBar1");
        Barco barco2 = new Barco(1000, "modeloBar2", "marcaBar2");

        Caminhao caminhao1 = new Caminhao(3000, "modeloCam1", "marcaCam1", true);
        Caminhao caminhao2 = new Caminhao(3000, "modeloCam2", "marcaCam1", false);

        LogisticaAquatica logisticaAquatica = new LogisticaAquatica();
        LogisticaTerrestre logisticaTerrestre = new LogisticaTerrestre();

        System.out.println("Esta auditado? " + logisticaAquatica.auditar());
        System.out.println("Entrega planejada para " + logisticaAquatica.planejarEntrega() + " dias.");
        logisticaAquatica.criarTransporte(barco1);
        logisticaAquatica.criarTransporte(barco2);

        logisticaTerrestre.auditar();
        System.out.println("Entrega planejada para " + logisticaTerrestre.planejarEntrega() + " dias.");
        logisticaTerrestre.criarTransporte(caminhao1);
        logisticaTerrestre.criarTransporte(caminhao2);

        System.out.println(logisticaAquatica.getTransportes());
        System.out.println(logisticaTerrestre.getTransportes());

    }

}
