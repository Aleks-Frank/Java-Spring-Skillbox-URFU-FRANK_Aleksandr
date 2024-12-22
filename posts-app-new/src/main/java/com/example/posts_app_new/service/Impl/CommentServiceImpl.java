package com.example.posts_app_new.service.Impl;

import com.example.posts_app_new.DTO.CommentDTO;
import com.example.posts_app_new.mapper.CommentMapper;
import com.example.posts_app_new.model.Comment;
import com.example.posts_app_new.model.Post;
import com.example.posts_app_new.repository.CommentRepository;
import com.example.posts_app_new.repository.PostRepository;
import com.example.posts_app_new.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private final CommentMapper commentMapper;

    @Override
    public List<CommentDTO> findById(Long id) {
        return commentRepository.findAll().stream()
                .filter(c -> c.getPost().getId().equals(id))
                .map(commentMapper::commentToDTO)
                .toList();
    }

    @Override
    public CommentDTO save(Long idPost, CommentDTO commentDTO) {
        Post post = postRepository.findById(idPost).orElse(null);
        if (post != null){
            Comment comment = commentMapper.commentToEntity(commentDTO);
            comment.setPost(post);
            comment = commentRepository.save(comment);
            return commentMapper.commentToDTO(comment);
        }
        return null;
    }

    @Override
    public CommentDTO update(Long id, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment != null){
            comment.setComment(commentDTO.getComment());
            commentRepository.save(comment);
            return commentMapper.commentToDTO(comment);
        }

        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
