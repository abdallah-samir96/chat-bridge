package com.chat.app.service.impl;

import com.chat.app.dto.ClientDTO;
import com.chat.app.dto.MessageDTO;
import com.chat.app.service.ClientReceiver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientReceiverImpl extends UnicastRemoteObject implements ClientReceiver {

    private final ClientDTO clientDTO;
    public ClientReceiverImpl(ClientDTO clientDTO) throws RemoteException {
        this.clientDTO = new ClientDTO(clientDTO.username(), clientDTO.email());
    }
    @Override
    public void receive(MessageDTO message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public ClientDTO getClientInfo() throws RemoteException {
        return clientDTO;
    }
}
