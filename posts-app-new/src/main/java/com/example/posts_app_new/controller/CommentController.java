package com.example.posts_app_new.controller;

import com.example.posts_app_new.CheckPosts;
import com.example.posts_app_new.DTO.CommentDTO;
import com.example.posts_app_new.service.Impl.CommentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl commentService;

    @GetMapping("/posts/{idPost}")
    public ResponseEntity<List<CommentDTO>> findById(@PathVariable Long idPost){
        return ResponseEntity.ok(commentService.findById(idPost));
    }

    @PostMapping("/posts/{idPost}")
    public ResponseEntity<CommentDTO> saveComment(@PathVariable Long idPost, @Valid @RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.save(idPost, commentDTO));
    }

    @PutMapping("/idComment")
    @CheckPosts
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long idComment, @Valid @RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.update(idComment, commentDTO));
    }

    @DeleteMapping("/idComment")
    @CheckPosts
    public ResponseEntity<Void> deleteById(@PathVariable Long idComment){
        commentService.deleteComment(idComment);
        return ResponseEntity.noContent().build();
    }

}
