package com.chat.app.dto;

import com.chat.app.model.Gender;

import java.io.Serializable;
import java.rmi.Remote;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        Gender gender,
        String mobile,
        byte[] avatar,
        String extension
) implements Serializable {
}