package Models;

public class HepatitisB extends Vacin{
    private String output;

    public HepatitisB(Persoon persoon) {
        super(persoon);
    }

    @Override
    void Registreer() {
        output = "";
        output += "Hepatitis B";
        output += "\n\t" + persoon.toString();
    }

    @Override
    void Informeer() {
        output += "\n\t* Informeer: Informatiekaartje Hepatitis B word overhandigd aan " + persoon.getVoornaam();
    }

    @Override
    void Voorbereiden() {
        output += "\n\t* Voorbereiden:"
                + "\n\t\tVaccin word uit de frigo gehaald"
                + "\n\t\tVaccin mengelen in glas met cola"
                + "\n\t\tVaccin optrekken in spuitje"
                + "\n\t\tBil van " + persoon.getVoornaam() + " ontsmetten";
    }

    @Override
    void Toedienen() {
        output += "\n\t* Toedienen: Spuitje word in de rechterbil toegediend";
    }

    @Override
    void Nazorg() {
        output += "\n\t* Nazorg:"
                + "\n\t\tPlakkertje word geplakt"
                + "\n\t\t" + persoon.getVoornaam() + " blijft verplicht nog 10 minuten wachten en mag hierna pas naar huis"
                + "\n\t\tDe dokter registreert de Hepatitis B vaccin van " + persoon.getVoornaam() + " in de databank van vaccinaties";
    }

    @Override
    public String toString() {
        return super.toString() + output;
    }
}
