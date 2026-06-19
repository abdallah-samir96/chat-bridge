package com.chat.app.dto;

import java.io.Serializable;
import java.rmi.Remote;
import java.time.LocalDateTime;

public record MessageDTO(String from, String to, String text, LocalDateTime timestamp) implements Remote, Serializable {

}
