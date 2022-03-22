package ru.itis.nasibullin.messages.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.ReplyType;
import ru.itis.nasibullin.messages.listeners.MessageListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MessageHandlerImpl implements MessageHandler {
    protected List<MessageListener> listeners;

    public MessageHandlerImpl() {
        listeners = new ArrayList<>();
    }

    @Override
    public Reply handle(Update update) {
        if (update.getMessage().getText().startsWith("/")) {
            return handleCommand(update);
        } else {
            return handleText(update);
        }
    }


    private Reply handleCommand(Update update) {
        Reply reply = null;

        Iterator<MessageListener> iterator = listeners.iterator();
        String locale = update.getMessage().getFrom().getLanguageCode();

        while (iterator.hasNext() && reply == null) {
            reply = iterator.next().onMessage(update, locale);
        }
        return reply;
    }

    private Reply handleText(Update update) {
        return new Reply(update.getMessage().getChatId().toString(), update.getMessage().getText(), ReplyType.TEXT);
    }

    @Override
    public boolean addEventListeners(MessageListener... listeners) {
        return Collections.addAll(this.listeners, listeners);
    }
}
