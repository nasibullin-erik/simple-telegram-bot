IMAGE_NAME=telegram-bot-example
BOT_TOKEN=
BOT_NAME=
CURRENCY_TOKEN=
WEATHER_TOKEN=
docker build -t $IMAGE_NAME .
docker run \
-e bot.token=$BOT_TOKEN \
-e bot.name=$BOT_NAME \
-e currency.token=$CURRENCY_TOKEN \
-e weather.token=$WEATHER_TOKEN \
--rm $IMAGE_NAME