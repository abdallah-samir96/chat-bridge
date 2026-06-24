package com.chat.app.service;

import com.chat.app.dto.MessageDTO;
import com.chat.app.model.Message;
import com.chat.app.repository.MessageRepository;
import com.chat.app.utils.converter.MessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageServiceDetails {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceDetails.class);

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageServiceDetails() {
        this.messageRepository = new MessageRepository();
        this.messageMapper = new MessageMapper();
    }

    public Message add(MessageDTO messageDTO) {
       logger.info("Adding new Message from : {} to: {}", messageDTO.from(), messageDTO.to());

       return null;
    }
}
