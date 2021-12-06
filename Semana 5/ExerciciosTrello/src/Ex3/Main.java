package Ex3;

import java.util.Arrays;

import static java.time.LocalDateTime.now;
import static java.util.Calendar.getInstance;
import static java.util.Locale.getISOLanguages;

public class Main {

    public static void main(String[] args) {

        System.out.println(now());
        System.out.println(getInstance().getTimeZone().getDisplayName());
        System.out.println(Arrays.toString(getISOLanguages()));

    }

}
