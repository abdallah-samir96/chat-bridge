package com.chat.app.service.impl;

import com.chat.app.dto.MessageDTO;
import com.chat.app.dto.UserRequestDTO;
import com.chat.app.service.ClientReceiver;
import com.chat.app.service.MessageService;
import com.chat.app.service.MessageServiceDetails;
import com.chat.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {
    private final static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
    private final Map<String, ClientReceiver> clients = new ConcurrentHashMap<>();
    private final UserService userService;
    public MessageServiceImpl() throws RemoteException {
        this.userService = new UserService();
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
    public void register(ClientReceiver client, UserRequestDTO dto) throws RemoteException {
        logger.info("Register client with user dto");
        if(client == null) {
            return;
        }
        var loginDetails = userService.create(dto);
        client.receiveLoginDetails(loginDetails);
        clients.put(client.getClientInfo().username(), client);
    }
}