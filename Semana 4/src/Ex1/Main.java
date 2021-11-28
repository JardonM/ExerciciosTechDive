package Ex1;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        LocalDateTime atual = LocalDateTime.now();

        if (atual.getHour() > 5 && atual.getHour() < 13) {
            System.out.println("Bom dia, no momento são " + atual.getHour() + ":" + atual.getMinute() + ".");
        } else if (atual.getHour() >= 13 && atual.getHour() < 18) {
            System.out.println("Boa tarde, no momento são " + atual.getHour() + ":" + atual.getMinute() + ".");
        } else {
            System.out.println("Boa noite, no momento são " + atual.getHour() + ":" + atual.getMinute() + ".");
        }
    }

}
