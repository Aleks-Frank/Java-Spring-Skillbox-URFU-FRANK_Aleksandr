package com.example.posts_app_new.mapper;

import com.example.posts_app_new.DTO.CategoryDTO;
import com.example.posts_app_new.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO categoryToDTO(Category category);

    Category categoryToEntity(CategoryDTO categoryDTO);

}
