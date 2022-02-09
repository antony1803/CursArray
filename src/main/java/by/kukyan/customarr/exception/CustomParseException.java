package by.kukyan.customarr.exception;

public class CustomParseException extends Exception{
    public CustomParseException() {
        super();
    }

    public CustomParseException(String message) {
        super(message);
    }

    public CustomParseException(Throwable cause) {
        super(cause);
    }

    public CustomParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
