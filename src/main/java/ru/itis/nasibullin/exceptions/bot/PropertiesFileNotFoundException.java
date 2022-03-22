package ru.itis.nasibullin.exceptions.bot;

public class PropertiesFileNotFoundException extends RuntimeException {
    public PropertiesFileNotFoundException() {
        super();
    }

    public PropertiesFileNotFoundException(String message) {
        super(message);
    }

    public PropertiesFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesFileNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PropertiesFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
