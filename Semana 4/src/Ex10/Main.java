package Ex10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Você gostaria de calcular a PA ou a PG? ");
        String progressao = input.nextLine();


        System.out.print("Digite o valor inicial: ");
        int inicial = input.nextInt();

        System.out.print("Digite a raiz: ");
        int raiz = input.nextInt();


        switch (progressao){
            case "PA" -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(inicial);
                    inicial += raiz;
                }
            }
            case "PG" -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(inicial);
                    inicial *= raiz;
                }
            }
        }


    }

}
