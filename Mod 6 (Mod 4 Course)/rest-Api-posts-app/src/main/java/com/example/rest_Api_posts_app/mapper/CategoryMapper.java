package com.example.rest_Api_posts_app.mapper;

import com.example.rest_Api_posts_app.model.Category;
import com.example.rest_Api_posts_app.web.request.UpsertCategoryRequest;
import com.example.rest_Api_posts_app.web.response.category.CategoryFindAllResponse;
import com.example.rest_Api_posts_app.web.response.category.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {PostMapper.class})
public interface CategoryMapper {

    Category requestToCategory(UpsertCategoryRequest request);

    @Mapping(source = "categoryId", target = "id")
    Category requestToCategory(Long categoryId, UpsertCategoryRequest request);

    CategoryResponse categoryToResponse(Category category);

    CategoryFindAllResponse categoryFindAllToResponse(Category category);

}
