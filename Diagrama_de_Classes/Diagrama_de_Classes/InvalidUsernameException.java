package Diagrama_de_Classes;

public class InvalidUsernameException extends Exception {

    public InvalidUsernameException(){
        super();
    }

    public InvalidUsernameException(String error){
        super(error);
    }
}

class InvalidPasswordException extends Exception{
    public InvalidPasswordException() {super();}
    public InvalidPasswordException(String error){super(error);}
}

class UserNotLoggedInException extends Exception{
    public UserNotLoggedInException() {super();}
    public UserNotLoggedInException(String error) {super(error);}
}