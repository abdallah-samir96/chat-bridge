package com.chat.app.exception;

import java.util.List;

public class ValidationException extends RuntimeException {

    public ValidationException(List<String> errors) {
        super(String.join(",", errors));
    }
}