package Exceptions;

public class stockCritException extends stockException{

    public stockCritException(String output) {
        super(output + " verlaging geweigerd !");
    }
}
