package com.example.posts_app_new.service.Impl;

import com.example.posts_app_new.DTO.PostDTO;
import com.example.posts_app_new.mapper.PostsMapper;
import com.example.posts_app_new.model.Post;
import com.example.posts_app_new.repository.PostRepository;
import com.example.posts_app_new.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final PostsMapper postsMapper;

    @Override
    public Page<PostDTO> findAll(Pageable pageable) {
        return postRepository.findAll(pageable).map(postsMapper::postToDTO);
    }

    @Override
    public PostDTO findById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null){
            return postsMapper.postToDTO(post);
        }
        return null;
    }

    @Override
    public Page<PostDTO> filterPosts(String category, String userAuthor, Pageable pageable) {
        return (Page<PostDTO>) postRepository.findAll(pageable)
                .map(postsMapper::postToDTO)
                .filter(o -> o.getUserAuthor().equalsIgnoreCase(userAuthor) && o.getCategory().equalsIgnoreCase(category));
    }

    @Override
    public PostDTO save(PostDTO postDTO) {
        Post post = postsMapper.postToEntity(postDTO);
        post = postRepository.save(post);
        return postsMapper.postToDTO(post);
    }

    @Override
    public PostDTO update(Long id, PostDTO postDTO) {
        Post existedPost = postRepository.findById(id).orElse(null);
        if(existedPost != null){
            existedPost.setHeadLine(postDTO.getHeadLine());
            existedPost.setBodyLine(postDTO.getBodeLine());
            existedPost.setCategory(existedPost.getCategory());
            postRepository.save(existedPost);
            return postsMapper.postToDTO(existedPost);
        }

        return null;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
