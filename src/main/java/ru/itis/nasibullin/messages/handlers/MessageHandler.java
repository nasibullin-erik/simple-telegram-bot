package ru.itis.nasibullin.messages.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.listeners.MessageListener;

public interface MessageHandler {
    boolean addEventListeners(MessageListener... listeners);
    Reply handle(Update update);
}
