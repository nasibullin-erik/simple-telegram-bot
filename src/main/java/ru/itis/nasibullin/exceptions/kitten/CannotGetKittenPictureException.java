package ru.itis.nasibullin.exceptions.kitten;

public class CannotGetKittenPictureException extends Exception {
    public CannotGetKittenPictureException() {
    }

    public CannotGetKittenPictureException(String message) {
        super(message);
    }

    public CannotGetKittenPictureException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotGetKittenPictureException(Throwable cause) {
        super(cause);
    }

    public CannotGetKittenPictureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
