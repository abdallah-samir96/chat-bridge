package com.chat.app.utils.converter;

import com.chat.app.dto.MessageDTO;
import com.chat.app.model.Message;

public class MessageConverter implements Converter<Message, MessageDTO>{

    @Override
    public Message toEntity(MessageDTO dto) {
        System.out.printf("converting dto to entity : %s", dto);
        return null;
    }

    @Override
    public MessageDTO toDTO(Message entity) {
        return null;
    }
}
