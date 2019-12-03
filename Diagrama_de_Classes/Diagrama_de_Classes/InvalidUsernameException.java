package Diagrama_de_Classes;

public class InvalidUsernameException extends Exception {

    public InvalidUsernameException(){
        super();
    }

    public InvalidUsernameException(String error){
        super(error);
    }
}
