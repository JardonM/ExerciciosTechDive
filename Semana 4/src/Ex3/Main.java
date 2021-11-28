package Ex3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite sua altura em metros(ex 0,00): ");
        double altura = input.nextDouble();

        System.out.print("Digite seu peso em kg: ");
        double peso = input.nextDouble();

        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC é de: %.2f", imc);

    }

}
