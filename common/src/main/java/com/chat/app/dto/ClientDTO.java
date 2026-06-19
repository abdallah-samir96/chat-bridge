package com.chat.app.dto;

import java.io.Serializable;

public record ClientDTO(String username, String email) implements Serializable { }
