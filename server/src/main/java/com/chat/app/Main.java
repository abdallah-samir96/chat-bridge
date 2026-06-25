package com.chat.app;

import com.chat.app.repository.config.DataSourceConfig;
import com.chat.app.service.impl.ChattingBridgeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import static com.chat.app.utils.ConfigurationProperties.SERVER_PORT;
import static com.chat.app.utils.ConfigurationProperties.SERVICE_NAME;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());
    public static void main(String[] args)  {
        Runtime.getRuntime().addShutdownHook(new Thread(DataSourceConfig::shutdown));
        startServer();
    }

    private static void startServer()  {
        try {
            logger.info("Trying to start the server using port :{}", SERVER_PORT);
            var registry = LocateRegistry.createRegistry(SERVER_PORT);
            var messageServer = new ChattingBridgeImpl();
            registry.rebind(SERVICE_NAME, messageServer);
            logger.info("Server Started");
            Thread.currentThread().join();
        } catch (RemoteException e) {
            logger.error("There is exception when trying to start the server, message: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            logger.error("Exception when waiting other threads, message: {}", e.getMessage());
        }
    }
}