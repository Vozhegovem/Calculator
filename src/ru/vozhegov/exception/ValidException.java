package ru.vozhegov.exception;

public class ValidException extends Exception {
    public ValidException() {
    }

    public ValidException(String message) {
        super(message);
    }

    public ValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidException(Throwable cause) {
        super(cause);
    }
}
