package com.chat.app.service;

import com.chat.app.dto.UserRequestDTO;
import com.chat.app.model.User;
import com.chat.app.repository.UserRepository;
import com.chat.app.repository.config.DataSourceConfig;
import com.chat.app.utils.ConfigurationProperties;
import com.chat.app.utils.converter.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService() {
        this.userRepository = new UserRepository(DataSourceConfig.getDatasource());
        this.userMapper = new UserMapper();
    }
    public boolean create(UserRequestDTO userDTO) {
        logger.info("Create user with details: {}", userDTO);
        // save avatar
        // handle password hashing
        // save into the DB
        var avatarPath = FileManager.upload(ConfigurationProperties.S3_BUCKET_PATH, userDTO.avatar(), userDTO.extension());
        var user = userMapper.toEntity(userDTO);
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
        return userRepository.get(email);
    }

}
