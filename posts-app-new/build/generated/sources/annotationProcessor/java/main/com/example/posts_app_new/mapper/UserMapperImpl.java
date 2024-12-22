package com.example.posts_app_new.mapper;

import com.example.posts_app_new.DTO.UserDTO;
import com.example.posts_app_new.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-22T12:15:31+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setNameUser( user.getNameUser() );
        userDTO.setEmailUser( user.getEmailUser() );

        return userDTO;
    }

    @Override
    public User userToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setNameUser( userDTO.getNameUser() );
        user.setEmailUser( userDTO.getEmailUser() );

        return user;
    }
}
