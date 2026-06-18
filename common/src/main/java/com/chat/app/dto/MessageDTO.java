package com.chat.app.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record MessageDTO(String to, String description, LocalDateTime timestamp) implements Serializable {

}
