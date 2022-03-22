package ru.itis.nasibullin.exceptions.exchangeRate;

public class WrongCurrencyException extends Exception {
    public WrongCurrencyException() {
    }

    public WrongCurrencyException(String message) {
        super(message);
    }

    public WrongCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCurrencyException(Throwable cause) {
        super(cause);
    }

    public WrongCurrencyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
