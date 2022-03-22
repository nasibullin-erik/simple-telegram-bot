package ru.itis.nasibullin.utils;

import ru.itis.nasibullin.messages.localizer.Localizer;
import ru.itis.nasibullin.messages.localizer.LocalizerImpl;
import ru.itis.nasibullin.services.exchangeRate.Currency;

public class ExchangeRateUtils {
    public static String toBeautifulOutput(Currency currency, String locale) {
        Localizer localizer = new LocalizerImpl();
        double rounded = (double) Math.round(currency.getPrice() * 100) / 100;
        return currency.getCount() + " " + currency.getFrom() + " " + localizer.localize("exchange_rate.costs", locale) + " " + rounded + " " + currency.getTo();
    }
}
