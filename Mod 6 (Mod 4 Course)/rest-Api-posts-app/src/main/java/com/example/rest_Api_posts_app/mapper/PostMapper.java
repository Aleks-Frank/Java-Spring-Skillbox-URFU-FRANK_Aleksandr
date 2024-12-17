package com.example.rest_Api_posts_app.mapper;

import com.example.rest_Api_posts_app.model.Post;
import com.example.rest_Api_posts_app.web.request.UpsertPostRequest;
import com.example.rest_Api_posts_app.web.response.post.PostFindAllResponse;
import com.example.rest_Api_posts_app.web.response.post.PostResponse;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@DecoratedWith(PostMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CommentMapper.class})
public interface PostMapper {

    Post requestToPost(UpsertPostRequest request);

    @Mapping(source = "idPost", target = "id")
    Post requestToPost(Long idPost, UpsertPostRequest request);

    @Mapping(source = "user.nameUser", target = "nameUser")
    PostResponse postToResponse(Post post);

    @Mapping(source = "user.nameUser", target = "nameUser")
    PostFindAllResponse postFindAllToResponse(Post post);

}
