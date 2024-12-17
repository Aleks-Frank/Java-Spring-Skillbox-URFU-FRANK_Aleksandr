package com.example.rest_Api_posts_app.mapper;

import com.example.rest_Api_posts_app.model.User;
import com.example.rest_Api_posts_app.web.request.UpsertUserRequest;
import com.example.rest_Api_posts_app.web.response.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {PostMapper.class, CommentMapper.class})
public interface UserMapper {

    User requestToUser(UpsertUserRequest request);

    @Mapping(source = "idUser", target = "id")
    User requestToUser(Long idUser, UpsertUserRequest request);

    UserResponse userToResponse(User user);
}
