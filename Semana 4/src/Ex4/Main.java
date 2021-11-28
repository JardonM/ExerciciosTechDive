package Ex4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = input.nextInt();

        if(numero % 2 == 0 ) {
            System.out.println(numero + " é par.");
        } else {
            System.out.println(numero + " é impar.");
        }

    }

}
