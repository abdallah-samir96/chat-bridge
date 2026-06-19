package com.chat.app.service.impl;

import com.chat.app.dto.MessageDTO;
import com.chat.app.service.ClientReceiver;
import com.chat.app.service.MessageService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService{
    private final Map<String, ClientReceiver> clients = new ConcurrentHashMap<>();

    public MessageServiceImpl() throws RemoteException {

    }

    @Override
    public void send(MessageDTO message) throws RemoteException {
        System.out.printf("Message to Send :%s " , message);
        var receiver = clients.get(message.to());
        if (receiver == null) {
            throw new RemoteException("Receiver '" + message.to() + "' is not connected.");
        }
        receiver.receive(message);
    }

    @Override
    public void register(ClientReceiver client) throws RemoteException {
        System.out.printf("Trying to register client: %s", client);
        if(client == null) {
            return;
        }
        clients.put(client.getClientInfo().username(), client);
    }
}