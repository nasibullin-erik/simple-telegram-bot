package ru.itis.nasibullin.services.weather;

import ru.itis.nasibullin.exceptions.weather.CannotGetWeatherInfoException;
import ru.itis.nasibullin.exceptions.weather.WrongCityInWeatherException;

public interface Synoptic {
    Weather getWeather(String city, String locale) throws CannotGetWeatherInfoException, WrongCityInWeatherException;
}
