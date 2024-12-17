package com.example.rest_Api_posts_app.repository;

import com.example.rest_Api_posts_app.model.Comment;
import com.example.rest_Api_posts_app.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByIdUser(Long idUser);

    List<Comment> findAllByIdPost(Long idPost);

    Long countPostsById(Long idPost);

    void deleteByIdAndUser(Long id, Long idUser);

}
