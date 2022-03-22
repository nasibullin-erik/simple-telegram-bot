package ru.itis.nasibullin.messages.listeners;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itis.nasibullin.exceptions.kitten.CannotGetKittenPictureException;
import ru.itis.nasibullin.messages.Reply;
import ru.itis.nasibullin.messages.ReplyType;
import ru.itis.nasibullin.services.kitten.KittenService;
import ru.itis.nasibullin.services.kitten.KittenServiceCataasImpl;

import java.util.Arrays;

public class KittenListener extends MessageListener {
    private static final String[] KITTEN_COMMANDS = {"/kitten", "/котя"};

    private final KittenService kittenService;
    public KittenListener() {
        super();
        kittenService = new KittenServiceCataasImpl();
    }

    @Override
    public Reply onMessage(Update update, String locale) {
        if (Arrays.asList(KITTEN_COMMANDS).contains(update.getMessage().getText())) {
            Reply reply = new Reply();
            reply.setChatId(update.getMessage().getChatId().toString());
            try {
                reply.setData(kittenService.getKitten());
                reply.setReplyType(ReplyType.PHOTO);
            } catch (CannotGetKittenPictureException e) {
                reply.setReplyType(ReplyType.TEXT);
                reply.setData(localizer.localize("kitten.error", locale));
            }
            return reply;
        }
        return null;
    }
}
