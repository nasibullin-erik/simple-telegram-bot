package ru.itis.nasibullin.utils;

import ru.itis.nasibullin.messages.localizer.Localizer;
import ru.itis.nasibullin.messages.localizer.LocalizerImpl;
import ru.itis.nasibullin.services.weather.Weather;

public class WeatherUtils {
    public static String toBeautifulOutput(Weather weather, String locale) {
        Localizer localizer = new LocalizerImpl();

        return
          localizer.localize("weather.city", locale) + ": " + weather.getCity() + "\n" +
          //localizer.localize("weather.state", locale) + ": " + weather.getState() + "\n" +
          localizer.localize("weather.description", locale) + ": " + weather.getDescription() + "\n" +
          localizer.localize("weather.temperature", locale) + ": " + weather.getTemperature() + localizer.localize("weather.celsius_symbol", locale) + "\n" +
          localizer.localize("weather.feels_like", locale) + ": " + weather.getFeelsLike() + localizer.localize("weather.celsius_symbol", locale) + "\n" +
          localizer.localize("weather.visibility", locale) + ": " + weather.getVisibility() + " " + localizer.localize("weather.visibility_symbol", locale) + "\n" +
          localizer.localize("weather.pressure", locale) + ": " + weather.getPressure() + " " + localizer.localize("weather.pressure_symbol", locale) + "\n" +
          localizer.localize("weather.humidity", locale) + ": " + weather.getHumidity() + localizer.localize("weather.humidity_symbol", locale) + "\n" +
          localizer.localize("weather.wind_speed", locale) + ": " + weather.getWindSpeed() + " " + localizer.localize("weather.wind_speed_symbol", locale) + "\n";
    }
}
