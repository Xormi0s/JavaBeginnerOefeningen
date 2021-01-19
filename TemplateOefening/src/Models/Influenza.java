package Models;

public class Influenza extends Vacin{
    private String output;

    public Influenza(Persoon persoon) {
        super(persoon);
    }

    @Override
    void Registreer() {
        output = "";
        output += "Influenza";
        output += "\n\t" + persoon.toString();
    }

    @Override
    void Informeer() {
        output += "\n\t* Informeer: Brochure over Influenza word overhandigd aan " + persoon.getVoornaam();
    }

    @Override
    void Voorbereiden() {
        output += "\n\t* Voorbereiden:"
                + "\n\t\tVaccin word uit de voorraadkast gehaald"
                + "\n\t\tVaccin schudden voor 1 minuut lang"
                + "\n\t\tVaccin optrekken in spuitje"
                + "\n\t\tArm van " + persoon.getVoornaam() + " ontsmetten";
    }

    @Override
    void Toedienen() {
        output += "\n\t* Toedienen: Spuitje word in de rechter arm toegediend";
    }

    @Override
    void Nazorg() {
        output += "\n\t* Nazorg:"
                + "\n\t\tPlakkertje word geplakt"
                + "\n\t\t" + persoon.getVoornaam() + " blijft verplicht nog 5 minuten wachten en mag hierna pas naar huis"
                + "\n\t\tDe dokter registreert de Influenza vaccin van " + persoon.getVoornaam() + " in de databank van vaccinaties";
    }

    @Override
    public String toString() {
        return super.toString() + output;
    }

}
