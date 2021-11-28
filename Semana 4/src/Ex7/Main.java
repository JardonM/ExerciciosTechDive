package Ex7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double soma = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Digite a " + i + "ª nota: ");
            soma += input.nextDouble();
        }

        double media = soma / 3;

        System.out.printf("Sua média final é: %.2f.", media);

    }

}
