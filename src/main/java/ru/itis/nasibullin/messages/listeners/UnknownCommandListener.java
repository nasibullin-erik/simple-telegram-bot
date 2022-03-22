package ru.itis.nasibullin.messages.listeners;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.ReplyType;

public class UnknownCommandListener extends MessageListener {

    @Override
    public Reply onMessage(Update update, String locale) {
        return new Reply(update.getMessage().getChatId().toString(), localizer.localize("bot.wrong_command", locale), ReplyType.TEXT);
    }
}
