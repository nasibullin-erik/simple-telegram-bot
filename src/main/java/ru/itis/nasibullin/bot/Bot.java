package ru.itis.nasibullin.bot;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.handlers.MessageHandler;
import ru.itis.nasibullin.messages.handlers.MessageHandlerImpl;
import ru.itis.nasibullin.messages.listeners.MessageListener;

import java.io.InputStream;

public class Bot extends TelegramLongPollingBot {
    private final Logger logger;
    protected final MessageHandler messageHandler;
    protected final String token;
    protected final String name;


    public Bot(String token, String name) {
        super();
        logger = Logger.getLogger(this.getClass());
        messageHandler = new MessageHandlerImpl();
        logger.log(Level.DEBUG, "Creating bot with token " + token + ", name " + name);
        this.token = token;
        this.name = name;
        logger.log(Level.DEBUG, "Bot has been initialized");
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && !update.getMessage().getFrom().getIsBot()) {
            handleUpdate(update);
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    protected void handleUpdate(Update update) {
        Reply reply = messageHandler.handle(update);
        sendMessage(reply);
    }

    private void sendMessage(Reply reply) {
        try {
            switch (reply.getReplyType()) {
                case TEXT:
                    SendMessage message = new SendMessage();
                    message.setText((String) reply.getData());
                    message.setChatId(reply.getChatId());
                    execute(message);
                    break;
                case PHOTO:
                    SendPhoto photo = new SendPhoto();
                    photo.setPhoto(new InputFile((InputStream) reply.getData(), "photo"));
                    photo.setChatId(reply.getChatId());
                    execute(photo);
                    break;
            }
        } catch (TelegramApiException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    public void addEventListeners(MessageListener... listeners) {
        messageHandler.addEventListeners(listeners);
    }
}
