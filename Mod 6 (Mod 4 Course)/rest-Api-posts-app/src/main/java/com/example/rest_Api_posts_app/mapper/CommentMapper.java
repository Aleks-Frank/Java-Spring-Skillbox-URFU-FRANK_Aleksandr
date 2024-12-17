package com.example.rest_Api_posts_app.mapper;

import com.example.rest_Api_posts_app.model.Comment;
import com.example.rest_Api_posts_app.web.request.UpsertCommentRequest;
import com.example.rest_Api_posts_app.web.response.comment.CommentResponse;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@DecoratedWith(CommentMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    Comment requestToComment(UpsertCommentRequest request);

    @Mapping(source = "idComment", target = "id")
    Comment requestToComment(Long idComment, UpsertCommentRequest request);

    @Mapping(source = "user.nameUser", target = "nameUser")
    CommentResponse commentToResponse(Comment comment);
}
