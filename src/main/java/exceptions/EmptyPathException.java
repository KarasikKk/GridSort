package exceptions;

public class EmptyPathException extends RuntimeException{
    public EmptyPathException(){
        super("The path is empty.");
    }
}
