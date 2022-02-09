package by.kukyan.customarr.exception;

public class CustomReadException extends Exception{
    public CustomReadException () {
        super();
    }

    public CustomReadException (String message) {
        super(message);
    }

    public CustomReadException (Throwable cause) {
        super(cause);
    }

    public CustomReadException (String message, Throwable cause) {
        super(message, cause);
    }
}
