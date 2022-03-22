package ru.itis.nasibullin.messages.listeners;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.ReplyType;

import java.util.Arrays;

public class StartListener extends MessageListener {
    private static final String[] START_COMMANDS = {"/start", "/старт"};

    @Override
    public Reply onMessage(Update update, String locale) {
        if (Arrays.asList(START_COMMANDS).contains(update.getMessage().getText())) {
            return new Reply(update.getMessage().getChatId().toString(), localizer.localize("bot.start", locale), ReplyType.TEXT);
        }
        return null;
    }
}
