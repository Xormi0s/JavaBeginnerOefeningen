package Generator.Dummy;

import java.time.LocalDate;
import java.util.Random;

public class DummyPersonen {
    private static final String[] voornamen = {"Jonas", "Ellen", "Bram", "Lisa", "Kevin", "Lore", "Tom", "Lies", "Thomas", "Anais"};
    private static final String[] achternamen = {"Bourguignon", "Hermans", "Vandenbroeck", "Alaerts", "Bogaerts", "Tuts", "Vanherwegen", "Deroost", "Andries"};
    private static final Random random = new Random();

    public static String getVoornaam(){
        return voornamen[random.nextInt(voornamen.length)];
    }

    public static String getAchternaam(){
        return achternamen[random.nextInt(achternamen.length)];
    }

    public static LocalDate getGeboortedatum(){
        int jaar = 1900 + random.nextInt(LocalDate.now().getYear() - 1900);
        int maand = 1 + random.nextInt(11);
        int dag = 1 + random.nextInt(25);
        LocalDate geboortedatum = LocalDate.of(jaar, maand, dag);

        return geboortedatum;
    }
}
