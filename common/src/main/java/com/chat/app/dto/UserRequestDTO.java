package com.chat.app.dto;

import com.chat.app.model.Gender;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        Gender gender,
        String mobile,
        byte[] avatar,
        String extension
) {
}