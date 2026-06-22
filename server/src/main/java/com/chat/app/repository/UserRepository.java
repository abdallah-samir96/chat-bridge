package com.chat.app.repository;

import com.chat.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserRepository {

    private final DataSource dataSource;

    private final static Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository(DataSource source) {
        logger.info("creating user repository with datasource");
        this.dataSource = source;
    }

    public boolean add(User user) {
        logger.info("Adding user into datastore!");
        // findByUsername

        var sqlQuery = "insert into user(name, email, password, gender, mobile, created_at) values(?,?,?,?,?,?)";

        try (
                var connection = dataSource.getConnection();
                var statement = connection.prepareStatement(sqlQuery);
        ) {

//            statement.setString();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;

    }
}
