package com.chat.app.dto;

import java.io.Serializable;

public record LoginDTO(String name, String email, String accessToken) implements Serializable { }
