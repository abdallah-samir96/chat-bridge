package com.chat.app.dto;

import java.io.Serializable;

public record  LoginResponseDTO(String name, String email, String password) implements Serializable { }
