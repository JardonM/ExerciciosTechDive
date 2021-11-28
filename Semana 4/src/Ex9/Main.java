package Ex9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int fatorial = 0;

        System.out.print("Digite um numero de 0 a 10: ");
        int numero = input.nextInt();
        if(numero < 0 || numero > 10) {
            System.out.println("Numero invalido.");
        } else {
            fatorial = numero;
        }

        while (numero > 1) {
            fatorial = fatorial * (numero - 1);
            numero--;
        }

        System.out.println(fatorial);

    }

}
