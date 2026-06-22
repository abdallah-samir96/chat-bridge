package com.chat.app.service.impl;

import com.chat.app.dto.ClientDTO;
import com.chat.app.dto.LoginDTO;
import com.chat.app.dto.MessageDTO;
import com.chat.app.service.ClientReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientReceiverImpl extends UnicastRemoteObject implements ClientReceiver {

    private final ClientDTO clientDTO;
    private static final Logger logger = LoggerFactory.getLogger(ClientReceiverImpl.class);
    public ClientReceiverImpl(ClientDTO clientDTO) throws RemoteException {
        this.clientDTO = new ClientDTO(clientDTO.username(), clientDTO.email());
    }
    @Override
    public void receive(MessageDTO message) throws RemoteException {
        logger.info("Receiving message: {}", message);
    }

    @Override
    public ClientDTO getClientInfo() throws RemoteException {
        return clientDTO;
    }

    @Override
    public void receiveLoginDetails(LoginDTO dto) throws RemoteException {
        logger.info("receive login details From Server to Client: {}", dto);
    }
}
