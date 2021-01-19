package Models;

public class Dtp extends Vacin{
    private String output;

    public Dtp(Persoon persoon) {
        super(persoon);
    }

    @Override
    void Registreer() {
        output = "";
        output += "DTP";
        output += "\n\t" + persoon.toString();
    }

    @Override
    void Informeer() {
        output += "\n\t* Informeer: Brochure over bijwerkingen DTP word overhandigd aan " + persoon.getVoornaam();
    }

    @Override
    void Voorbereiden() {
        output += "\n\t* Voorbereiden:"
                + "\n\t\tVaccin aftappen uit vat"
                + "\n\t\tVaccin verdunnen met water"
                + "\n\t\tVaccin optrekken in spuitje"
                + "\n\t\tArm van " + persoon.getVoornaam() + " ontsmetten";
    }

    @Override
    void Toedienen() {
        output += "\n\t* Toedienen: Spuitje word in de linker arm toegediend";
    }

    @Override
    void Nazorg() {
        output += "\n\t* Nazorg:"
                + "\n\t\tPlakkertje word geplakt"
                + "\n\t\t" + persoon.getVoornaam() + " blijft verplicht nog 30 minuten wachten en mag hierna pas naar huis"
                + "\n\t\tDe dokter registreert de DTP vaccin van " + persoon.getVoornaam() + " in de databank van vaccinaties";
    }

    @Override
    public String toString() {
        return super.toString() + output;
    }
}
