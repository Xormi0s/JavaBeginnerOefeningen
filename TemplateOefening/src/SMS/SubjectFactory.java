package SMS;

public class SubjectFactory {

    public static Subject createSubject(int y){
        switch (y){
            case 0: return new Subject("Stadhuis Leuven, Marktstraat 35, 02/02/2021 om 14:00u");
            case 1: return new Subject("Stadhuis Brussel, Getestraat 12, 28/01/2021 om 10:00u");
            case 2: return new Subject("Stadhuis Gent, VisStraat 01, 08/02/2021 om 11:30u");
            case 3: return new Subject("Stadhuis Antwerpen, Technologielaan 135, 30/01/2021 om 16:00u");
            case 4: return new Subject("Stadhuis Hasselt, Mulkstraat 55, 15/03/2021 om 10:15u");
            default: return null;
        }
    }
}
