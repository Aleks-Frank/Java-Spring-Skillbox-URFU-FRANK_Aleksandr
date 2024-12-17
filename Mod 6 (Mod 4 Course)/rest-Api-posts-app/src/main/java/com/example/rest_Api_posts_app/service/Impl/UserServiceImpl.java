package com.example.rest_Api_posts_app.service.Impl;

import com.example.rest_Api_posts_app.model.User;
import com.example.rest_Api_posts_app.repository.UserRepository;
import com.example.rest_Api_posts_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(int pageNum, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User existedUser = userRepository.findById(user.getId()).orElse(null);
        if (existedUser != null){
            existedUser.setNameUser(user.getNameUser());
            existedUser.setEmail(user.getEmail());
            existedUser.setComments(user.getComments());
            existedUser.setPosts(user.getPosts());
            return userRepository.save(existedUser);
        }
        return null;
    }

    @Override
    public User deleteById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            userRepository.deleteById(id);
            return user;
        }

        return null;
    }
}
