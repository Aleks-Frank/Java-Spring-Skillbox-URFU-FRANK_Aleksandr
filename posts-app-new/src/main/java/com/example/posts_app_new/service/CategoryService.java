package com.example.posts_app_new.service;

import com.example.posts_app_new.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO save(CategoryDTO categoryDTO);

    CategoryDTO update(Long id, CategoryDTO categoryDTO);

    void deleteById(Long id);

}
