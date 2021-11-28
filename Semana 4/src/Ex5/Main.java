package Ex5;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int numeroAleatorio = random.nextInt(5) + 1;

        System.out.print("Adivinhe um numero de 1 a 5: ");
        Scanner input = new Scanner(System.in);
        int numeroUsuario = input.nextInt();

        if(numeroAleatorio == numeroUsuario) {
            System.out.println("Você acertou!");
        } else {
            System.out.println("Você errou, o número correto era " + numeroAleatorio);
        }

    }

}
