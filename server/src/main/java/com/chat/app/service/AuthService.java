package com.chat.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    /**
     * This method takes the email, password and return access token
     *
     */
    public String login(String email, String password) {
        logger.info("user with email: {} try to login", email);
        // getting the user with email
        // hash the password
        // compare the password with the db password and return token using token manager

    }
}
