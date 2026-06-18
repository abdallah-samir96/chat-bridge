package com.chat.app.service.impl;

import com.chat.app.dto.MessageDTO;
import com.chat.app.service.MessageService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService{
    public MessageServiceImpl() throws RemoteException {

    }

    @Override
    public void send(MessageDTO dto) {
        System.out.println("Message to Send : " + dto);
    }
}
