package com.example.posts_app_new.service;

import com.example.posts_app_new.DTO.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    UserDTO update(Long id, UserDTO userDTO);

    void deleteById(Long id);

}
