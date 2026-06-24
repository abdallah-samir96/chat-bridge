package com.chat.app.repository;

import com.chat.app.model.Message;
import com.chat.app.model.User;
import com.chat.app.repository.config.DataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class MessageRepository {

    private final DataSource dataSource;

    private final static Logger logger = LoggerFactory.getLogger(MessageRepository.class);

    public MessageRepository() {
        this.dataSource = DataSourceConfig.getDatasource();
    }

    public boolean add(User user) {
        logger.info("Adding Message into datastore");
        return true;
    }

    /**
     * This method should return all messages between 2 pairs (sender, receiver)
     * @param pairs represents the sender and receiver
     * */
    public List<Message> getByIds(List<Long> pairs) {
        return null;
    }


    public boolean delete(String email) {
        // no hard delete implemented
        return true;
    }
}
