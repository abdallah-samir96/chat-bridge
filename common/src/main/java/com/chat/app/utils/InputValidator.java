package com.chat.app.utils;

import com.chat.app.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private final List<String> errors = new ArrayList<>();

    private final static String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private final static String mobileRegex = "^01[0-9]{9}$";
    private InputValidator() {}

    public static InputValidator validator() {
        return new InputValidator();
    }

    public InputValidator notNullOrEmpty(String text, String fieldName) {
        if (text == null || text.trim().isEmpty()) {
            errors.add(fieldName + " must not be empty or Null");
        }
        return this;
    }

    public InputValidator email(String email) {
        if (email == null || !email.matches(emailRegex)) {
            errors.add("Invalid email format, should be valid like abc@gmail.com");
        }
        return this;
    }

    public InputValidator password(String password) {
        if (password == null || password.length() < 8) {
            errors.add("Password must be at least 8 characters");
        }
        return this;
    }

    public InputValidator mobile(String mobile) {
        if (mobile == null || !mobile.matches(mobileRegex)) {
            errors.add("Invalid mobile number format the format should start with 01, length should be 11");
        }
        return this;
    }

    public void validate() {
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}