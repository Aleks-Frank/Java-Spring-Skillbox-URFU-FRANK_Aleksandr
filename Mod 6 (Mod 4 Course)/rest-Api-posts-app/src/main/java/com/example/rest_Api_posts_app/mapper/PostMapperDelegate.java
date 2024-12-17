package com.example.rest_Api_posts_app.mapper;

import com.example.rest_Api_posts_app.model.Category;
import com.example.rest_Api_posts_app.model.Post;
import com.example.rest_Api_posts_app.service.CategoryService;
import com.example.rest_Api_posts_app.service.CommentService;
import com.example.rest_Api_posts_app.service.UserService;
import com.example.rest_Api_posts_app.web.request.UpsertPostRequest;
import com.example.rest_Api_posts_app.web.response.post.PostFindAllResponse;
import com.example.rest_Api_posts_app.web.response.post.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class PostMapperDelegate implements PostMapper{

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Post requestToPost(UpsertPostRequest request) {
        Post post = new Post();
        post.setHeadLine(request.getHeadLine());
        post.setDescription(request.getDescription());
        post.setBodyLine(request.getBodyLine());
        Category category = categoryService.findByName(request.getCategoryName());
        if (category == null) {
            category = new Category();
            category.setNameCategory(request.getCategoryName());
            category = categoryService.save(category);
        }
        post.setCategory(category);
        post.setUser(userService.findById(request.getUserId()));
        post.setComments(commentService.findAllByIdUser(request.getUserId()));
        return post;
    }

    @Override
    public Post requestToPost(Long postId, UpsertPostRequest request) {
        Post post = requestToPost(request);
        post.setId(postId);
        return post;
    }

    @Override
    public PostResponse postToResponse(Post post) {
        PostResponse response = postMapper.postToResponse(post);
        response.setCountComment(post.getComments().size());
        response.setNameUser(post.getUser().getNameUser());
        response.setComments(post.getComments().stream()
                .map(it -> commentMapper.commentToResponse(it))
                .toList());

        return response;
    }

    @Override
    public PostFindAllResponse postFindAllToResponse(Post post) {
        PostFindAllResponse response = postMapper.postFindAllToResponse(post);
        response.setCountComment(post.getComments().size());
        response.setNameUser(post.getUser().getNameUser());
        return response;
    }
}
