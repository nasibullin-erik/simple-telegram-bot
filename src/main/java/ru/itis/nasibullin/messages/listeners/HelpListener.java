package ru.itis.nasibullin.messages.listeners;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.ReplyType;

import java.util.Arrays;

public class HelpListener extends MessageListener {
    private static final String[] HELP_COMMANDS = {"/help", "/помощь"};

    @Override
    public Reply onMessage(Update update, String locale) {
        if (Arrays.asList(HELP_COMMANDS).contains(update.getMessage().getText())) {
            return new Reply(update.getMessage().getChatId().toString(), localizer.localize("bot.help", locale), ReplyType.TEXT);
        }
        return null;
    }
}
