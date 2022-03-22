package ru.itis.nasibullin;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.itis.nasibullin.bot.Bot;
import ru.itis.nasibullin.exceptions.InvalidPropertyException;
import ru.itis.nasibullin.messages.listeners.*;
import ru.itis.nasibullin.utils.PropertiesLoader;

import java.util.Map;


public class App {
    private Logger logger;
    private Bot bot;

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.init();
    }

    private void init() {
        initLogger();
        initBot();
    }

    private void initLogger() {
        logger = Logger.getLogger(this.getClass());
    }

    private void initBot() {
        logger.log(Level.INFO, "Initializing bot...");
        try {
            String botToken = PropertiesLoader.getInstance().getProperty("bot.token");
            String botName = PropertiesLoader.getInstance().getProperty("bot.name");
            bot = new Bot(botToken, botName);

            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);
            addEventListeners();
            logger.log(Level.INFO, "Bot has been initialized");
        } catch (TelegramApiException | InvalidPropertyException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    private void addEventListeners() throws InvalidPropertyException {
        bot.addEventListeners(
            new StartListener(),
            new HelpListener(),
            new KittenListener(),
            new CurrencyListener(PropertiesLoader.getInstance().getProperty("currency.token")),
            new WeatherListener(PropertiesLoader.getInstance().getProperty("weather.token")),
            new UnknownCommandListener());
    }
}
