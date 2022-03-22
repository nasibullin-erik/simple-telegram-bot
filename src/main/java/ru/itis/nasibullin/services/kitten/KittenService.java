package ru.itis.nasibullin.services.kitten;

import ru.itis.nasibullin.exceptions.kitten.CannotGetKittenPictureException;

import java.io.InputStream;

public interface KittenService {
    InputStream getKitten() throws CannotGetKittenPictureException;
}
