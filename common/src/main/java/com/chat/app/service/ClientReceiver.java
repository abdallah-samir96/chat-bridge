package com.chat.app.service;

import com.chat.app.dto.LoginResponseDTO;
import com.chat.app.dto.MessageDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientReceiver extends Remote {
    void receive(MessageDTO message) throws RemoteException;
    void receiveLoginDetails(LoginResponseDTO dto) throws RemoteException;
}
