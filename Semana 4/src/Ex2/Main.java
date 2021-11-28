package Ex2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu sobrenome: ");
        String sobreNome = input.nextLine();

        System.out.print("Digite seu nome: ");
        String nome = input.nextLine();

        System.out.println(nome + " " + sobreNome + ", seu nome contém " + nome.length() + " letras.\nSeu nome completo contém " + (nome.length() + sobreNome.length()) + " letras.");
    }

}
