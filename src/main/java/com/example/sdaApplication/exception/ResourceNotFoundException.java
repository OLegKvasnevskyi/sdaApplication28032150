package com.example.sdaApplication.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public static final String RESOURCE_NOT_FOUND = "Resource not found";
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
        super(RESOURCE_NOT_FOUND);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }
}

