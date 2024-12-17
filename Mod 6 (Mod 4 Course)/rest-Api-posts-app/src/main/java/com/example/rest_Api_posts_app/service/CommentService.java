package com.example.rest_Api_posts_app.service;

import com.example.rest_Api_posts_app.model.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(Long id);

    List<Comment> findAllByIdUser(Long idUser);

    List<Comment> findAllByIdPost(Long idPost);

    Comment save(Comment comment);

    Comment update(Comment comment);

    Long countAllByIdPosts(Long idPost);

    Comment deleteByIdAndUser(Long id, Long idUser);

}
