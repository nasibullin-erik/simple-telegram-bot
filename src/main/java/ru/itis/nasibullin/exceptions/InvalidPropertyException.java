package ru.itis.nasibullin.exceptions;

public class InvalidPropertyException extends Exception {
    public InvalidPropertyException() {
        super();
    }

    public InvalidPropertyException(String s) {
        super(s);
    }

    public InvalidPropertyException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidPropertyException(Throwable throwable) {
        super(throwable);
    }

    protected InvalidPropertyException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
