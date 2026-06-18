package com.chat.app;

import com.chat.app.dto.MessageDTO;
import com.chat.app.service.MessageService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        var message = new MessageDTO("abdallah", "simple description", LocalDateTime.now());
        var registry = LocateRegistry.getRegistry(8080);
        var service = (MessageService)registry.lookup("messageService");
        service.send(message);

    }
}