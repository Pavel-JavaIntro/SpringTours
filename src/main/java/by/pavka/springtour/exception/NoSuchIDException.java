package by.pavka.springtour.exception;

public class NoSuchIDException extends RuntimeException {
    public NoSuchIDException(String message) {
        super(message);
    }
}
