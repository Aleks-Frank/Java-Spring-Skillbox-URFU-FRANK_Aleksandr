package com.example.posts_app_new.service.Impl;

import com.example.posts_app_new.DTO.UserDTO;
import com.example.posts_app_new.mapper.UserMapper;
import com.example.posts_app_new.model.User;
import com.example.posts_app_new.repository.UserRepository;
import com.example.posts_app_new.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.userToEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.userToDto(user);
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        User existedUser = userRepository.findById(id).orElse(null);
        if (existedUser != null){
            existedUser.setNameUser(userDTO.getNameUser());
            existedUser.setEmailUser(userDTO.getEmailUser());
            existedUser = userRepository.save(existedUser);
            return userMapper.userToDto(existedUser);
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
