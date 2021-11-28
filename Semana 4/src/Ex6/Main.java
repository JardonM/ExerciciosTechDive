package Ex6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        System.out.print("Digite sua data de nascimento (dd/mm/yyyy): ");
        String anoNascString = input.nextLine();

        LocalDate anoNasc = LocalDate.parse(anoNascString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int idade = Period.between(anoNasc, LocalDate.now()).getYears();

        if(idade >= 18) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("Você é menor de idade.");
        }


    }

}
