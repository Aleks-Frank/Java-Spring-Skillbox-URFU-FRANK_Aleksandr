package com.example.posts_app_new.mapper;

import com.example.posts_app_new.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    com.example.posts_app_new.DTO.UserDTO userToDto(User user);

    User userToEntity(com.example.posts_app_new.DTO.UserDTO userDTO);

}
