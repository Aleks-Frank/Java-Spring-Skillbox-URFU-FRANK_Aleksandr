package com.example.posts_app_new.service;

import com.example.posts_app_new.DTO.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<PostDTO> findAll(Pageable pageable);

    PostDTO findById(Long id);

    Page<PostDTO> filterPosts(String category, String userAuthor, Pageable pageable);

    PostDTO save(PostDTO postDTO);

    PostDTO update(Long id, PostDTO postDTO);

    void deletePost(Long id);

}
