package com.chat.app;

import com.chat.app.service.MessageService;
import com.chat.app.service.impl.MessageServiceImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    private final static String SERVICE_NAME = "messageService";
    private final static short SERVER_PORT = 8080;

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