package re.exception;

public class MyCheckedException extends Exception{
    String message;
    public MyCheckedException(String message) {
        super(message);
    }
}