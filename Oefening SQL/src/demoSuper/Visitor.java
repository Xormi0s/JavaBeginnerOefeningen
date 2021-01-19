package demoSuper;

public class Visitor extends Person{
    private String numberBoard;

    public Visitor(String name, String firstName, String numberBoard) {
        super(name, firstName);
        this.numberBoard = numberBoard;
    }

    public String getNumberBoard() {
        return numberBoard;
    }

    public void setNumberBoard(String numberBoard) {
        this.numberBoard = numberBoard;
    }

    @Override
    public String toString() {
        return "Visitor{" +super.toString() +
                "\n \t numberBoard='" + numberBoard + '\'' +
                '}';
    }
}
