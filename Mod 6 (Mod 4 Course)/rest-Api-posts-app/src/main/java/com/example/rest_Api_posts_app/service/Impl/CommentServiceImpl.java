package com.example.rest_Api_posts_app.service.Impl;

import com.example.rest_Api_posts_app.aop.AccessibleDeleteComment;
import com.example.rest_Api_posts_app.model.Comment;
import com.example.rest_Api_posts_app.model.Post;
import com.example.rest_Api_posts_app.model.User;
import com.example.rest_Api_posts_app.repository.CommentRepository;
import com.example.rest_Api_posts_app.service.CommentService;
import com.example.rest_Api_posts_app.service.PostService;
import com.example.rest_Api_posts_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.rest_Api_posts_app.utils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final UserService userService;

    private final PostService postService;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findAllByIdUser(Long idUser) {
        List<Comment> comments = commentRepository.findAllByIdUser(idUser);
        if (comments != null){
            return comments;
        }

        return new ArrayList<>();
    }

    @Override
    public List<Comment> findAllByIdPost(Long idPost) {
        return commentRepository.findAllByIdPost(idPost);
    }

    @Override
    public Comment save(Comment comment) {
        User user = userService.findById(comment.getUser().getId());
        Post post = postService.findById(comment.getPost().getId());
        user.addComment(comment);
        post.addComment(comment);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        User user = userService.findById(comment.getUser().getId());
        Post post = postService.findById(comment.getPost().getId());
        Comment existedComment = findById(comment.getId());

        BeanUtils.copyNowNullProperties(comment, existedComment);
        existedComment.setUser(user);
        existedComment.setPost(post);
        return commentRepository.save(existedComment);
    }

    @Override
    public Long countAllByIdPosts(Long idPost) {
        return commentRepository.countPostsById(idPost);
    }

    @Override
    @Transactional
    @AccessibleDeleteComment
    public Comment deleteByIdAndUser(Long id, Long idUser) {
        Comment deletedComment = commentRepository.findById(id).orElse(null);
        commentRepository.deleteByIdAndUser(id, idUser);
        return deletedComment;
    }
}
