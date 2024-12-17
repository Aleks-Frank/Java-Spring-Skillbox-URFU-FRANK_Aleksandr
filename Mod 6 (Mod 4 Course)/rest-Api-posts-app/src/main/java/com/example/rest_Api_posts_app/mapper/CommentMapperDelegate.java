package com.example.rest_Api_posts_app.mapper;

import com.example.rest_Api_posts_app.model.Comment;
import com.example.rest_Api_posts_app.service.PostService;
import com.example.rest_Api_posts_app.service.UserService;
import com.example.rest_Api_posts_app.web.request.UpsertCommentRequest;
import com.example.rest_Api_posts_app.web.response.comment.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommentMapperDelegate implements CommentMapper{

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @Override
    public Comment requestToComment(UpsertCommentRequest request) {
        Comment comment = new Comment();
        comment.setComment(request.getComment());
        comment.setUser(userService.findById(request.getUserId()));
        comment.setPost(postService.findById(request.getPostId()));
        return comment;
    }

    @Override
    public Comment requestToComment(Long commentId, UpsertCommentRequest request) {
        Comment comment = requestToComment(request);
        comment.setId(commentId);
        return comment;
    }

}
