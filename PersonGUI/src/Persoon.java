import java.sql.Date;
import java.time.LocalDate;

public class Persoon {
    private String voornaam;
    private String naam;
    private Date geboortedatum;
    private String adres;
    private int postcode;
    private String Gemeente;

    public Persoon(String voornaam, String naam, Date geboortedatum, String adres, int postcode, String gemeente) {
        this.voornaam = voornaam;
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
        this.postcode = postcode;
        Gemeente = gemeente;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return Gemeente;
    }

    public void setGemeente(String gemeente) {
        Gemeente = gemeente;
    }
}
