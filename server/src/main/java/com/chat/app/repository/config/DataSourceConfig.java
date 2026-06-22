package com.chat.app.repository.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class DataSourceConfig {

    private static final HikariDataSource dataSource;
    private final static String url = "jdbc:mysql://localhost:3306/chatting_bridge";
    private final static String username = "root";
    // this will be passed through env variable
    private final static String password = "root";
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    static {

        var config = new HikariConfig();
        config.setPoolName("chat-bridge-pool");
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setIdleTimeout(60_000);
        config.setMinimumIdle(2);
        config.setMaximumPoolSize(20);
        config.setConnectionTimeout(15_000);
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDatasource(){ return dataSource;}

    /**
     * close the datasource and the associated pool
     * */
    public static void shutdown() {
        logger.info("Trying to free connections from connection pool");
        dataSource.close();
    }


}
