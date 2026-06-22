package com.chat.app.service;

import com.chat.app.dto.MessageDTO;
import com.chat.app.dto.UserRequestDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* This is the contract */
public interface MessageService extends Remote {
    void send(MessageDTO message) throws RemoteException ;
    void register(ClientReceiver client, UserRequestDTO userRequestDTO) throws  RemoteException;
}
