package Exceptions;

public class stockHighException extends stockException{

    public stockHighException(String output) {
        super(output + " verhoging geweigerd !");
    }
}
