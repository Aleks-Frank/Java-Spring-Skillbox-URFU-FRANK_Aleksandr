package com.example.rest_Api_posts_app.service.Impl;

import com.example.rest_Api_posts_app.model.Category;
import com.example.rest_Api_posts_app.repository.CategoryRepository;
import com.example.rest_Api_posts_app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(int pageNum, int pageSize) {
        return categoryRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category existedCategory = categoryRepository.findById(category.getId()).orElse(null);
        if (existedCategory != null) {
            existedCategory.setNameCategory(category.getNameCategory());
            existedCategory.setPosts(category.getPosts());
            return categoryRepository.save(existedCategory);
        }
        return null;
    }

    @Override
    public Category deleteById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            categoryRepository.deleteById(id);
            return category;
        }
        return null;
    }
}
