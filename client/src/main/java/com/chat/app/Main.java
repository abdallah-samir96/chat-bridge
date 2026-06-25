package com.chat.app;

import com.chat.app.dto.ClientDTO;
import com.chat.app.dto.MessageDTO;
import com.chat.app.dto.UserRequestDTO;
import com.chat.app.model.Gender;
import com.chat.app.service.ChattingBridge;
import com.chat.app.service.impl.ClientReceiverImpl;
import com.chat.app.utils.ConfigurationProperties;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {

        var registry = LocateRegistry.getRegistry(ConfigurationProperties.SERVER_PORT);
        var service = (ChattingBridge)registry.lookup(ConfigurationProperties.SERVICE_NAME);

        var scanner = new Scanner(System.in);
        System.out.println("username: ");
        var username = scanner.nextLine();
        System.out.println("E-mail: ");
        var email = scanner.nextLine();
        var userDto = new UserRequestDTO(
                "Abdallah Samir",
                email,
                "12345678",
                Gender.MALE,
                "01097456260",
                "avatar".getBytes(),
                "png"
        );

        var client = new ClientReceiverImpl(new ClientDTO(username, email));
        service.register(client, userDto);

        while(true) {
            System.out.println("message: ");
            var message = scanner.nextLine();
            System.out.println("to");
            var to = scanner.nextLine();
            service.send(new MessageDTO(username, to, message, LocalDateTime.now()));
        }


    }
}