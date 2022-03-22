package ru.itis.nasibullin.messages.listeners;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.localizer.Localizer;
import ru.itis.nasibullin.messages.localizer.LocalizerImpl;

public abstract class MessageListener {
    protected Localizer localizer;
    public MessageListener() {
        localizer = new LocalizerImpl();
    }

    public abstract Reply onMessage(Update update, String locale);
}
