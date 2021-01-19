package Factory;

import Models.Persoon;

import java.time.LocalDate;

public class PersonenFactory {

    public static Persoon createPersoon(String voornaam, String achternaam, LocalDate geboortedatum){
        return  new Persoon(voornaam, achternaam, geboortedatum);
    }
}
