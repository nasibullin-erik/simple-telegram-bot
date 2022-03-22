package ru.itis.nasibullin.services.exchangeRate;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import ru.itis.nasibullin.exceptions.exchangeRate.WrongCurrencyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateCurrConvImpl implements ExchangeRate {
    private static final String CURR_CONV_URL = "https://free.currconv.com/api/v7/convert?";
    private final Logger logger;
    private final String apiKey;

    public ExchangeRateCurrConvImpl(String apiKey) {
        logger = Logger.getLogger(this.getClass());
        this.apiKey = apiKey;
    }

    @Override
    public Currency exchangeRate(String from, String to) throws WrongCurrencyException {
        try {
            String currency = from.toUpperCase() + "_" + to.toUpperCase();
            URL openWeatherUrl = new URL(CURR_CONV_URL +
              "q=" + currency +
              "&compact=ultra" +
              "&apiKey=" + apiKey);
            InputStream is = ((HttpURLConnection) openWeatherUrl.openConnection()).getInputStream();
            return new Currency(from, to, 1, inputStreamToDouble(is, currency));
        } catch (IOException | JSONException e) {
            logger.log(Level.ERROR, e);
            throw new WrongCurrencyException("Wrong currency: " + from + " or " + to);
        }
    }

    @Override
    public Currency exchangeRate(String from, String to, double count) throws WrongCurrencyException {
        Currency currency = exchangeRate(from,to);
        currency.setCount(count);
        currency.setPrice(currency.getPrice() * count);
        return currency;
    }

    private double inputStreamToDouble(InputStream is, String key) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String tempString = null;
        while ((tempString = reader.readLine()) != null){
            response.append(tempString);
        }
        return new JSONObject(response.toString()).getDouble(key);
    }
}
