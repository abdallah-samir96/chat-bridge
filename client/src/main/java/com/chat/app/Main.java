package com.chat.app;

import com.chat.app.dto.ClientDTO;
import com.chat.app.dto.MessageDTO;
import com.chat.app.service.MessageService;
import com.chat.app.service.impl.ClientReceiverImpl;
import com.chat.app.utils.ConfigurationProperties;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static void connectDB() {
        try {
            var dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatting_bridge", "root", "root");
            var statement = dbConnection.prepareStatement("insert into hello(name, title) values(?,?)");
            statement.setString(1, "Hello Name");
            statement.setString(2, "This is the title");
            // false mean there is no resultSet
            var result = statement.execute();
            System.out.println(result);
            dbConnection.close();
        } catch (SQLException e) {

            System.out.println("Could not connect" + e.getMessage());
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws RemoteException, NotBoundException {


        var registry = LocateRegistry.getRegistry(ConfigurationProperties.SERVER_PORT);
        var service = (MessageService)registry.lookup(ConfigurationProperties.SERVICE_NAME);

        var scanner = new Scanner(System.in);
        System.out.println("Username: ");
        var username = scanner.next();
        System.out.println("Email: ");
        var email = scanner.next();
        var client = new ClientReceiverImpl(new ClientDTO(username, email));
        service.register(client);


        while(true) {
            System.out.println("Do you want to send message? ");
            boolean sendMessage = scanner.nextBoolean();
            scanner.nextLine();
            if(!sendMessage) {
                continue;
            }
            System.out.print("Write the receiver username: ");
            var to = scanner.next();
            scanner.nextLine(); // consume newline after next()
            System.out.print("Write the Message: ");
            var text = scanner.nextLine();
            var message = new MessageDTO(username, to, text, LocalDateTime.now());
            service.send(message);
        }


    }
}