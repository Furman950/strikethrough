package exceptions;

public class InvalidBirthdayException extends IllegalArgumentException{
    private static final long serialVersionUID = 1L;

    public InvalidBirthdayException() {
    }

    public InvalidBirthdayException(String s) {
        super(s);
    }

    public InvalidBirthdayException(Throwable cause) {
        super(cause);
    }

    public InvalidBirthdayException(String message, Throwable cause) {
        super(message, cause);
    }
}
