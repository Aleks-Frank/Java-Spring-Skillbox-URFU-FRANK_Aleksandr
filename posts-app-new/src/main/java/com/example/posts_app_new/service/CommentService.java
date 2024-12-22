package com.example.posts_app_new.service;

import com.example.posts_app_new.DTO.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findById(Long id);

    CommentDTO save(Long idPost, CommentDTO commentDTO);

    CommentDTO update(Long id, CommentDTO commentDTO);

    void deleteComment(Long id);

}
