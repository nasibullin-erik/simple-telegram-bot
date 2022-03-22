package ru.itis.nasibullin.exceptions.weather;

public class WrongCityInWeatherException extends Exception {
    public WrongCityInWeatherException() {
    }

    public WrongCityInWeatherException(String message) {
        super(message);
    }

    public WrongCityInWeatherException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCityInWeatherException(Throwable cause) {
        super(cause);
    }

    public WrongCityInWeatherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
