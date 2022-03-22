package ru.itis.nasibullin.services.weather;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import ru.itis.nasibullin.exceptions.weather.CannotGetWeatherInfoException;
import ru.itis.nasibullin.exceptions.weather.WrongCityInWeatherException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SynopticOpenWeatherImpl implements Synoptic {
    private static final String OPEN_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String UNITS = "metric";
    private final Logger logger;
    private final String apiKey;

    public SynopticOpenWeatherImpl(String apiKey) {
        logger = Logger.getLogger(this.getClass());
        this.apiKey = apiKey;
    }


    @Override
    public Weather getWeather(String city, String locale) throws CannotGetWeatherInfoException, WrongCityInWeatherException {
        try {
            URL openWeatherUrl = new URL(OPEN_WEATHER_URL +
              "q=" + city +
              "&units=" + UNITS +
              "&lang=" + locale +
              "&appid=" + apiKey);
            InputStream is = ((HttpURLConnection) openWeatherUrl.openConnection()).getInputStream();
            return inputStreamToWeather(is);
        } catch (MalformedURLException | CannotGetWeatherInfoException e) {
            logger.log(Level.ERROR, e);
            throw new CannotGetWeatherInfoException("Cannot connect to " + OPEN_WEATHER_URL);
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
            throw new WrongCityInWeatherException("Wrong city: " + city);
        }
    }


    private Weather inputStreamToWeather(InputStream is) throws CannotGetWeatherInfoException {
        try {
            JSONObject jsonObject = inputStreamToJSON(is);
            JSONObject jsonObjectWeather = jsonObject.getJSONArray("weather").getJSONObject(0);
            JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
            JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
            return Weather.builder()
              .city(jsonObject.getString("name"))
              .temperature(jsonObjectMain.getDouble("temp"))
              .feelsLike(jsonObjectMain.getDouble("feels_like"))
              .windSpeed(jsonObjectWind.getDouble("speed"))
              .pressure(jsonObjectMain.getDouble("pressure"))
              .humidity(jsonObjectMain.getDouble("humidity"))
              .state(jsonObjectWeather.getString("main"))
              .description(jsonObjectWeather.getString("description"))
              .visibility(jsonObject.getInt("visibility"))
              .build();
        } catch (Exception e) {
            logger.log(Level.ERROR, e);
            throw new CannotGetWeatherInfoException(e);
        }
    }

    private JSONObject inputStreamToJSON(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String tempString = null;
        while ((tempString = reader.readLine()) != null){
            response.append(tempString);
        }
        return new JSONObject(response.toString());
    }
}
