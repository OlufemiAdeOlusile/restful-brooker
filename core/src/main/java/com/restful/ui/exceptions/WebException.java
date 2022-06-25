package com.restful.ui.exceptions;

/**
 * @author olufemi
 *
 */
public class WebException extends RuntimeException {

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }
}
