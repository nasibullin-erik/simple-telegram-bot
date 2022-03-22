package ru.itis.nasibullin.services.exchangeRate;

import ru.itis.nasibullin.exceptions.exchangeRate.WrongCurrencyException;

public interface ExchangeRate {
    Currency exchangeRate(String from, String to) throws WrongCurrencyException;
    Currency exchangeRate(String from, String to, double count) throws WrongCurrencyException;
}
