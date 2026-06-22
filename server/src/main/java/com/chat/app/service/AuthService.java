package com.chat.app.service;

import com.chat.app.utils.HashingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserService service;

    public AuthService() {
        logger.info("Initializing Auth Service!");
        service = new UserService();
    }
    /**
     * This method takes the email, password and return access token.
     * Token should be sent with each operation to guarantee Authenticity
     */
    public String login(String email, String password) {
        logger.info("user with email: {} try to login", email);
        var user = service.get(email);
        var hashedPassword = HashingUtils.generateHash(password);
        if(hashedPassword.equals(user.getPassword())) {
            return TokenManager.generateAndStore(email);
        }
        throw new RuntimeException("Credentials is not correct!!");
    }
}
