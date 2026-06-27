package com.chat.app.service.impl;

import com.chat.app.dto.LoginResponseDTO;
import com.chat.app.dto.MessageDTO;
import com.chat.app.service.ClientReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientReceiverImpl extends UnicastRemoteObject implements ClientReceiver {

    private static final Logger logger = LoggerFactory.getLogger(ClientReceiverImpl.class);

    public ClientReceiverImpl() throws RemoteException {

    }

    @Override
    public void receive(MessageDTO message) throws RemoteException {
        logger.info("Receiving message: {}", message);
    }


    @Override
    public void receiveLoginDetails(LoginResponseDTO dto) throws RemoteException {
        logger.info("receive login details From Server to Client: {}", dto);
    }
}
