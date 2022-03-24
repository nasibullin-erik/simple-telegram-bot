IMAGE_NAME=nasibullinei/simple-telegram-bot:latest
BOT_TOKEN=
BOT_NAME=
CURRENCY_TOKEN=
WEATHER_TOKEN=
docker run \
-e bot.token=$BOT_TOKEN \
-e bot.name=$BOT_NAME \
-e currency.token=$CURRENCY_TOKEN \
-e weather.token=$WEATHER_TOKEN \
--rm $IMAGE_NAME