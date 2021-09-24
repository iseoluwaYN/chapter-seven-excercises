package com.sages.exception;

public class TurtleException extends Exception{

    public TurtleException() {
    }

    public TurtleException(String message) {
        super(message);
    }

    public TurtleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TurtleException(Throwable cause) {
        super(cause);
    }
}
