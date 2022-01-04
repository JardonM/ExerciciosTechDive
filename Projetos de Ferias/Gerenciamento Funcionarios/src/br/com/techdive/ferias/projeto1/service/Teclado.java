package br.com.techdive.ferias.projeto1.service;

import java.util.Scanner;

public class Teclado {
    Scanner input = new Scanner(System.in);

    public String lerString(String mensagem) {
        System.out.print(mensagem);
        String conteudo = input.nextLine();
        if(conteudo.isEmpty()){
            conteudo = input.nextLine();
        }
        return conteudo;
    }

    public int lerInteger(String mensagem) {
        System.out.print(mensagem);
        int conteudo = input.nextInt();
        if(conteudo < 1) {
            conteudo = input.nextInt();
        }
        return conteudo;
    }

    public double lerDouble(String mensagem) {
        System.out.print(mensagem);
        double conteudo = input.nextDouble();
        if(conteudo < 1) {
            conteudo = input.nextDouble();
        }
        return conteudo;
    }
}