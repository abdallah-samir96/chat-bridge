package com.chat.app.service;

import com.chat.app.model.User;
import com.chat.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }
    public boolean create(User user) {
        logger.info("Create user with details: {}", user);
        var userAdded = userRepository.add(user);
        logger.info("User Added: {}", userAdded);
        return userAdded;
    }

    public boolean delete(String email) {
        logger.info("Delete user with email: {}", email);
        var user = get(email);
        if(user != null) {
            var userDeleted = userRepository.delete(email);
            logger.info("User : {}, deleted: {}", user, userDeleted);
            return userDeleted;
        }
        throw new RuntimeException("user with email: " + email + " is not exists in the system");
    }

    public User get(String email) {
        logger.info("Getting User info by email: {}", email);
        var user = userRepository.get(email);
        if(user != null) return user;

        throw new RuntimeException("user with email: " + email + " is not exists in the system");
    }

}
