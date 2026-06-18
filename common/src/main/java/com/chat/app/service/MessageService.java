package com.chat.app.service;

import com.chat.app.dto.MessageDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* This is the contract */
public interface MessageService extends Remote {
    void send(MessageDTO dto) throws RemoteException ;
}
