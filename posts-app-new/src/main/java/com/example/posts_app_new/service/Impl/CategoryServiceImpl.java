package com.example.posts_app_new.service.Impl;

import com.example.posts_app_new.DTO.CategoryDTO;
import com.example.posts_app_new.mapper.CategoryMapper;
import com.example.posts_app_new.model.Category;
import com.example.posts_app_new.repository.CategoryRepository;
import com.example.posts_app_new.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;


    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::categoryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryMapper.categoryToEntity(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.categoryToDTO(category);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category existedCategory = categoryRepository.findById(id).orElse(null);
        if (existedCategory != null){
            existedCategory.setNameCategory(categoryDTO.getNameCategory());
            existedCategory = categoryRepository.save(existedCategory);
            return categoryMapper.categoryToDTO(existedCategory);
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
