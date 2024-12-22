package com.example.posts_app_new.mapper;

import com.example.posts_app_new.DTO.PostDTO;
import com.example.posts_app_new.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostsMapper {

    @Mapping(target = "userAuthor", source = "author.userAuthor")
    @Mapping(target = "category", source = "category.nameCategory")
    PostDTO postToDTO(Post post);

    @Mapping(target = "author.id", source = "author")
    @Mapping(target = "category.id", source = "category")
    Post postToEntity(PostDTO postDTO);

}
