package ru.itis.nasibullin.messages.localizer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizerImpl implements Localizer {
    private static final String PATH_TO_MESSAGES = "messages.message";


    public LocalizerImpl() {
    }

    @Override
    public String localize(String key, String language) {
        return changeCharset(ResourceBundle.getBundle(PATH_TO_MESSAGES, new Locale(language)).getString(key), StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8);
    }


    protected String changeCharset(String text, Charset originalCharset, Charset newCharset) {
        return new String(text.getBytes(originalCharset), newCharset);
    }
}
