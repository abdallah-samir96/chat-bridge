package com.chat.app.service;

import com.chat.app.dto.MessageDTO;
import com.chat.app.model.Message;
import com.chat.app.repository.MessageRepository;
import com.chat.app.utils.converter.MessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService() {
        this.messageRepository = new MessageRepository();
        this.messageMapper = new MessageMapper();
    }

    public Message add(MessageDTO messageDTO) {
       logger.info("Adding new Message from : {} to: {}", messageDTO.from(), messageDTO.to());
       return null;
    }
    public List<Message> getAll(List<Long> pairs) {
        logger.info("The pairs to get all messages between: " , pairs);
        var messages = messageRepository.getByIds(pairs);
        return messages;
    }
}
