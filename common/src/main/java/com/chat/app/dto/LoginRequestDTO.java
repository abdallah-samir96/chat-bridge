package com.chat.app.dto;

import java.io.Serializable;

public record LoginRequestDTO(String email, String password) implements Serializable {
}
