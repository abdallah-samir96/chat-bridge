package com.chat.app.utils.converter;

import java.util.List;

/*
* Used for converting from any type to other type
* */
public interface Mapper<E, D>{
    E toEntity(D dto);
    D toDTO(E entity);
    default List<E> toEntity(List<D> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    default List<D> toDTO(List<E> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }
}
