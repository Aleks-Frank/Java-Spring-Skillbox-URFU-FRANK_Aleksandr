package com.example.rest_Api_posts_app.service;

import com.example.rest_Api_posts_app.model.Post;
import com.example.rest_Api_posts_app.web.request.PostFilterRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Page<Post> findAll(int pageNum, int pageSize);

    Post findById(Long id);

    Post save(Post post);

    Post update(Post post);

    Post deleteByIdAndUser(Long id, Long idUser);

    Page<Post> filterByPost(PostFilterRequest filterRequests);

}
