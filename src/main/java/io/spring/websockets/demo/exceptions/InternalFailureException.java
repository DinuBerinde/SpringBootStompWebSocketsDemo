package io.spring.websockets.demo.exceptions;

public class InternalFailureException extends RuntimeException {

    public InternalFailureException(String message) {
        super(message);
    }

}
