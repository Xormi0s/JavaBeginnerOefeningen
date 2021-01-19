package demoSuper;

public class TestPerson {
    public static void main(String[] args) {
        Person person[] = new Person[4];
        for(int i = 0; i<person.length; i++){
            switch (i){
                case 0: person[i]= new Visitor("Jefke","Smolders","1-ABC-123");break;
                case 1: person[i]= new Student("Marie", "Janssens","234567");break;
                case 2: person[i] = new Manager("Paul","De Croo", "098765","765","Mercedes");break;
                case 3: person[i] = new Docent("Mathy", "Paesen", "98765678","345","Java");break;
            }
        }

        for(int i = 0; i<person.length;i++){
            System.out.println(person[i]);
        }
    }
}
