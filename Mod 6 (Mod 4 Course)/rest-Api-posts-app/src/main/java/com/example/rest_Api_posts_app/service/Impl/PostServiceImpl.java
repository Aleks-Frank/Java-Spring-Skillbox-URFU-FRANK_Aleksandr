package com.example.rest_Api_posts_app.service.Impl;

import com.example.rest_Api_posts_app.model.Category;
import com.example.rest_Api_posts_app.model.Post;
import com.example.rest_Api_posts_app.model.User;
import com.example.rest_Api_posts_app.repository.PostRepository;
import com.example.rest_Api_posts_app.repository.SpecialPost;
import com.example.rest_Api_posts_app.service.CategoryService;
import com.example.rest_Api_posts_app.service.PostService;
import com.example.rest_Api_posts_app.service.UserService;
import com.example.rest_Api_posts_app.utils.BeanUtils;
import com.example.rest_Api_posts_app.web.request.PostFilterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.rest_Api_posts_app.aop.AccessibleUpdatePost;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> findAll(int pageNum, int pageSize) {
        return postRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post save(Post post) {
        User user = userService.findById(post.getUser().getId());
        Category category = categoryService.findById(post.getCategory().getId());
        user.addPost(post);
        category.addPost(post);
        return postRepository.save(post);
    }

    @Override
    @AccessibleUpdatePost
    public Post update(Post post) {
        User user = userService.findById(post.getUser().getId());
        Category category = categoryService.findById(post.getCategory().getId());
        Post existedPost = findById(post.getId());
        BeanUtils.copyNowNullProperties(post, existedPost);
        existedPost.setUser(user);
        existedPost.setCategory(category);
        return postRepository.save(existedPost);
    }

    @Override
    public Post deleteByIdAndUser(Long id, Long idUser) {
        Post deletePost = postRepository.findById(id).orElse(null);
        postRepository.deleteByIdAndUser(id, idUser);
        return deletePost;
    }

    @Override
    public Page<Post> filterByPost(PostFilterRequest filterRequests) {
        return postRepository.findAll(SpecialPost.withFilter(filterRequests), PageRequest.of(filterRequests.getPageNumber(), filterRequests.getPageSize()));
    }
}
