package ru.itis.nasibullin.messages.listeners;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.exceptions.weather.CannotGetWeatherInfoException;
import ru.itis.nasibullin.exceptions.weather.WrongCityInWeatherException;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.ReplyType;
import ru.itis.nasibullin.services.weather.Synoptic;
import ru.itis.nasibullin.services.weather.SynopticOpenWeatherImpl;
import ru.itis.nasibullin.utils.WeatherUtils;

import java.util.Arrays;

public class WeatherListener extends MessageListener {
    private static final String[] WEATHER_COMMANDS = {"/weather", "/погода"};
    private final Synoptic weatherService;


    public WeatherListener(String apiKey) {
        super();
        weatherService = new SynopticOpenWeatherImpl(apiKey);
    }

    @Override
    public Reply onMessage(Update update, String locale) {
        if (Arrays.asList(WEATHER_COMMANDS).contains(update.getMessage().getText().split(" ")[0])) {
            Reply reply = new Reply();
            reply.setChatId(update.getMessage().getChatId().toString());
            reply.setReplyType(ReplyType.TEXT);
            String[] parts = update.getMessage().getText().split(" ");
            if (parts.length < 2) {
                reply.setData(localizer.localize("weather.no_city", locale));
            } else {
                try {
                    reply.setData(WeatherUtils.toBeautifulOutput(weatherService.getWeather(parts[1], locale), locale));
                } catch (CannotGetWeatherInfoException e) {
                    reply.setData(localizer.localize("weather.error", locale));
                } catch (WrongCityInWeatherException e) {
                    reply.setData(localizer.localize("weather.wrong_city", locale) + ": " + parts[1]);
                }
            }
            return reply;
        }
        return null;
    }
}
