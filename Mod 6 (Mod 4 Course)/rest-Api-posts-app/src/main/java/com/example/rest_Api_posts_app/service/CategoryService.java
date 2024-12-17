package com.example.rest_Api_posts_app.service;

import com.example.rest_Api_posts_app.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Page<Category> findAll(int pageNum, int pageSize);

    Category findById(Long id);

    Category findByName(String name);

    Category save(Category category);

    Category update(Category category);

    Category deleteById(Long id);


}
