package Ex8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Escolha uma operação( + - * / ): ");
        String operacao = input.nextLine();

        System.out.print("Digite o primeiro número: ");
        double primeiro = input.nextDouble();

        System.out.print("Digite o segundo número: ");
        double segundo = input.nextDouble();




        switch (operacao) {
            case "+" -> System.out.println(primeiro + segundo);
            case "-" -> System.out.println(primeiro - segundo);
            case "*" -> System.out.println(primeiro * segundo);
            case "/" -> System.out.println(primeiro / segundo);
            default -> System.out.println("Operação invalida.");
        }



    }

}
