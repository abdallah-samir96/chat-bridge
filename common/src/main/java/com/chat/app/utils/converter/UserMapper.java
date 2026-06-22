package com.chat.app.utils.converter;

import com.chat.app.dto.UserRequestDTO;
import com.chat.app.model.User;

public class UserMapper implements Mapper<User, UserRequestDTO> {
    @Override
    public User toEntity(UserRequestDTO dto) {
        return new User.Builder()
                .name(dto.name())
                .email(dto.email())
                .mobile(dto.mobile())
                .password(dto.password())
                .gender(dto.gender())
                .build();
    }

    @Override
    public UserRequestDTO toDTO(User entity) {
        return null;
    }
}
