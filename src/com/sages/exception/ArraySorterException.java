package com.sages.exception;

public class ArraySorterException extends Exception{
    public ArraySorterException() {
    }

    public ArraySorterException(String message) {
        super(message);
    }

    public ArraySorterException(String message, Throwable ex) {
        super(message, ex);
    }

    public ArraySorterException(Throwable cause) {
        super(cause);
    }
}
