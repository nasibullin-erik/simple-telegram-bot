package ru.itis.nasibullin.exceptions.bot;

public class CannotConnectToUrlException extends Exception {
    public CannotConnectToUrlException() {
    }

    public CannotConnectToUrlException(String message) {
        super(message);
    }

    public CannotConnectToUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotConnectToUrlException(Throwable cause) {
        super(cause);
    }

    public CannotConnectToUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
