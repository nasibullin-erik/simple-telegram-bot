# Simple Telegram Bot

Telegram bot that can show the weather of a specified city, send a random picture with a cat and show the exchange rate

CATAAS service is used for cats

To send weather use OpenWeather service

The Currency Convertation service is used to send currency rates

Bot can process messages and reply in two languages - English and Russian

## Usage

This bot is available on [Telegram](https://telegram.me/java_test_2021_bot)

If you want to test this bot locally you, need to have docker and get tokens:

- Telegram bot token, which you can get from [BotFather](https://telegram.me/BotFather) in telegram 
- Weather token, which you can get from [OpenWeather](https://openweathermap.org/) site
- Currency token, which you can get from [Currency Convertation](https://free.currencyconverterapi.com/) site

These tokens you need to specify in "build-and-run.sh" file, and execute it

Or you can download it from docker hub and execute it without building images manually - get tokens like in the previous example and paste them to run-docker-hub.sh. Then execute this file.

