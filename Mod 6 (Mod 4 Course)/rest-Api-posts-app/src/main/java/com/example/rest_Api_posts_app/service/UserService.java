package com.example.rest_Api_posts_app.service;

import com.example.rest_Api_posts_app.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> findAll();

    Page<User> findAll(int pageNum, int pageSize);

    User findById(Long id);

    User save(User user);

    User update(User user);

    User deleteById(Long id);

}
