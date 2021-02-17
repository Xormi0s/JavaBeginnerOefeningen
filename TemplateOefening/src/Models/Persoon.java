package Models;

import SMS.Observer;
import SMS.Subject;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;

public class Persoon extends Observer {
    private String voornaam;
    private String achternaam;
    private LocalDate geboortedatum;
    private String riziv;


    public Persoon(String voornaam, String achternaam, LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        setRiziv();
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getRiziv() {
        return riziv;
    }

    public void setRiziv() {
        this.riziv = (String.valueOf(geboortedatum.getYear())).substring(2) + String.valueOf(geboortedatum.getMonthValue())
                +  String.valueOf(geboortedatum.getDayOfMonth()) + "-" + String.valueOf(geboortedatum.getYear() / 2) + "-"
                + String.valueOf(geboortedatum.getDayOfMonth() * 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoon)) return false;
        Persoon persoon = (Persoon) o;
        return voornaam.equals(persoon.voornaam) &&
                achternaam.equals(persoon.achternaam) &&
                geboortedatum.equals(persoon.geboortedatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voornaam, achternaam, geboortedatum);
    }

    @Override
    public String toString() {
        return "Patient: " + voornaam + " " + achternaam
                + "\n\tLeeftijd: " + (Period.between(geboortedatum, LocalDate.now())).getYears()
                + "\n\tRIZIV: " + riziv;
    }

    @Override
    public void update(String message) {
        System.out.println(voornaam + " " + achternaam + " -> sms bericht: " + message);
    }
}
