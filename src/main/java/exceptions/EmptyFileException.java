package exceptions;

public class EmptyFileException extends RuntimeException{
    public EmptyFileException(String filePath){
        super("File at " + filePath + " is empty.");
    }
}
