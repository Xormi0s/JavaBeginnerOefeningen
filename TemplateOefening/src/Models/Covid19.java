package Models;

public class Covid19 extends Vacin{
    private String output;

    public Covid19(Persoon persoon) {
        super(persoon);
    }

    @Override
    void Registreer() {
        output = "";
        output += "Covid-19";
        output += "\n\t" + persoon.toString();
    }

    @Override
    void Informeer() {
        output += "\n\t* Informeer: Papier Covid-19 bijwerkingen word overhandigd aan " + persoon.getVoornaam();
    }

    @Override
    void Voorbereiden() {
        output += "\n\t* Voorbereiden:"
                + "\n\t\tVaccin word uit de diepvriezer gehaald"
                + "\n\t\tVaccin laten opwarmen tot kamertemperatuur"
                + "\n\t\tVaccin optrekken in spuitje"
                + "\n\t\tBil van " + persoon.getVoornaam() + " ontsmetten";
    }

    @Override
    void Toedienen() {
        output += "\n\t* Toedienen: Spuitje word in de linkerbil toegediend";
    }

    @Override
    void Nazorg() {
        output += "\n\t* Nazorg:"
                + "\n\t\tPlakkertje word geplakt"
                + "\n\t\t" + persoon.getVoornaam() + " blijft verplicht nog 20 minuten wachten en mag hierna pas naar huis"
                + "\n\t\tDe dokter registreert de Covid-19 vaccin van " + persoon.getVoornaam() + " in de databank van vaccinaties";
    }

    @Override
    public String toString() {
        return super.toString() + output;
    }
}
