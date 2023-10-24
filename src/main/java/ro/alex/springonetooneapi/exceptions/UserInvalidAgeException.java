package ro.alex.springonetooneapi.exceptions;

public class UserInvalidAgeException extends RuntimeException{

    public UserInvalidAgeException(String message){
        super(message);
    }

}
