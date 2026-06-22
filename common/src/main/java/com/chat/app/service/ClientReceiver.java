package com.chat.app.service;

import com.chat.app.dto.ClientDTO;
import com.chat.app.dto.LoginDTO;
import com.chat.app.dto.MessageDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientReceiver extends Remote {
    void receive(MessageDTO message) throws RemoteException;
    ClientDTO getClientInfo() throws RemoteException;
    void receiveLoginDetails(LoginDTO dto) throws RemoteException;
}
