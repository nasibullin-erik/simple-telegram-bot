package ru.itis.nasibullin.messages.listeners;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.exceptions.exchangeRate.WrongCurrencyException;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.ReplyType;
import ru.itis.nasibullin.services.exchangeRate.ExchangeRate;
import ru.itis.nasibullin.services.exchangeRate.ExchangeRateCurrConvImpl;
import ru.itis.nasibullin.utils.ExchangeRateUtils;

import java.util.Arrays;

public class CurrencyListener extends MessageListener {
    private static final String[] CURRENCY_COMMANDS = {"/currency", "/валюта"};
    protected final ExchangeRate exchangeRateService;

    public CurrencyListener(String apiKey) {
        super();
        exchangeRateService = new ExchangeRateCurrConvImpl(apiKey);
    }

    @Override
    public Reply onMessage(Update update, String locale) {
        if (Arrays.asList(CURRENCY_COMMANDS).contains(update.getMessage().getText().split(" ")[0])) {
            Reply reply = new Reply();
            reply.setChatId(update.getMessage().getChatId().toString());
            reply.setReplyType(ReplyType.TEXT);
            String[] parts = update.getMessage().getText().split(" ");
            try {
                if (parts.length == 3) {
                    reply.setData(ExchangeRateUtils.toBeautifulOutput(exchangeRateService.exchangeRate(parts[1], parts[2]), locale));
                } else if (parts.length == 4) {
                    reply.setData(ExchangeRateUtils.toBeautifulOutput(exchangeRateService.exchangeRate(parts[1], parts[2], Double.parseDouble(parts[3])), locale));
                } else {
                    reply.setData(localizer.localize("bot.incorrect_command", locale));
                }
            } catch (WrongCurrencyException e) {
                reply.setData(localizer.localize("exchange_rate.wrong_currency", locale) + " " + parts[1] + " or " + parts[2]);
            }
            return reply;
        }
        return null;
    }
}
