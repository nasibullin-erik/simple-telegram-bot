package ru.itis.nasibullin.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.itis.nasibullin.exceptions.InvalidPropertyException;

public class PropertiesLoader {
    private static PropertiesLoader instance;
    private final Logger logger;

    private PropertiesLoader() {
        logger = Logger.getLogger(PropertiesLoader.class);
    }

    public static PropertiesLoader getInstance() {
        if (instance == null) {
            instance = new PropertiesLoader();
        }
        return instance;
    }

    public String getProperty(String key) throws InvalidPropertyException {
        String value = System.getenv(key);
        if (value == null) {
            logger.log(Level.DEBUG, "Getting property with key " + key);
            throw new InvalidPropertyException("Can not find property " + key);
        }
        return value;
    }
}
