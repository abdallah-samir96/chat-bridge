package com.chat.app;

import com.chat.app.service.impl.MessageServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import static com.chat.app.utils.ConfigurationProperties.SERVER_PORT;
import static com.chat.app.utils.ConfigurationProperties.SERVICE_NAME;

public class Main {


    public static void main(String[] args) {

        startServer();
    }

    private static void startServer() {
        try {
            System.out.printf("Trying to start the server on port : %d\n", SERVER_PORT);
            var registry = LocateRegistry.createRegistry(SERVER_PORT);
            var messageServer = new MessageServiceImpl();
            registry.rebind(SERVICE_NAME, messageServer);
            System.out.println("Server Started");
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}