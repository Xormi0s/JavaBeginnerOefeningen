package Models;

public abstract class Vacin {
    Persoon persoon;

    public Vacin(Persoon persoon) {
        this.persoon = persoon;
        Registreer();
        Informeer();
        Voorbereiden();
        Toedienen();
        Nazorg();
    }

    abstract void Registreer();
    abstract void Informeer();
    abstract void Voorbereiden();
    abstract void Toedienen();
    abstract void Nazorg();

    @Override
    public String toString() {
        return "";
    }
}
