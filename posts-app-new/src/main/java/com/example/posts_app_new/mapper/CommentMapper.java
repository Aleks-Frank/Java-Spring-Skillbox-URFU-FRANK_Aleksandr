package com.example.posts_app_new.mapper;

import com.example.posts_app_new.DTO.CommentDTO;
import com.example.posts_app_new.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "author", source = "author.userAuthor")
    CommentDTO commentToDTO(Comment comment);

    @Mapping(target = "author.userAuthor", source = "author")
    Comment commentToEntity(CommentDTO commentDTO);

}
