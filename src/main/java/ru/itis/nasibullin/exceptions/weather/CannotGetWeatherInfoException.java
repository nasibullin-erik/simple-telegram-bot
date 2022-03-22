package ru.itis.nasibullin.exceptions.weather;

public class CannotGetWeatherInfoException extends Exception {
    public CannotGetWeatherInfoException() {
    }

    public CannotGetWeatherInfoException(String message) {
        super(message);
    }

    public CannotGetWeatherInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotGetWeatherInfoException(Throwable cause) {
        super(cause);
    }

    public CannotGetWeatherInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
