package ru.itis.nasibullin.services.kitten;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.itis.nasibullin.exceptions.kitten.CannotGetKittenPictureException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class KittenServiceCataasImpl implements KittenService {
    private static final String CATAAS_URL = "https://cataas.com/cat/cute";
    private Logger logger;

    public KittenServiceCataasImpl() {
        logger = Logger.getLogger(this.getClass());
    }


    @Override
    public InputStream getKitten() throws CannotGetKittenPictureException {
        try {
            URL cataasUrl = new URL(CATAAS_URL);
            return ((HttpURLConnection) cataasUrl.openConnection()).getInputStream();
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new CannotGetKittenPictureException("Cannot connect to kitten service. " + e.getMessage());
        }
    }
}
