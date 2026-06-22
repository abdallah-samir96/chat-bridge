package com.chat.app.repository;

import com.chat.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserRepository {

    private final DataSource dataSource;

    private final static Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository(DataSource source) {
        this.dataSource = source;
    }

    public boolean add(User user) {
        logger.info("Adding user into datastore!");
        var sqlQuery = "insert into user(name, email, password, gender, mobile, avatar, created_at) values(?,?,?,?,?,?,?)";
        try (
                var connection = dataSource.getConnection();
                var statement = connection.prepareStatement(sqlQuery);
        ) {

            statement.setString(1, user.getName() );
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getGender().name());
            statement.setString(5, user.getMobile());
            statement.setString(6, user.getAvatar());
            statement.setTimestamp(7, Timestamp.valueOf(user.getCreatedAt()));
            statement.execute();
            return true;
        } catch (SQLException e) {
            logger.error("There are exception when adding new user: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public User get(String email) {

        return new User();
    }
    public boolean delete(String email) {
        // delete directly and see
        return true;
    }
}
