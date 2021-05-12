package com.restful.automation.exceptions;

/**
 * @author olufemi on 2021-05-11
 *
 * Runtime RestfulWebException
 */
public class RestfulWebException extends RuntimeException {

    public RestfulWebException(String message) {
        super(message);
    }

    public RestfulWebException(String message, Throwable cause) {
        super(message, cause);
    }
}
