package com.example.posts_app_new.controller;

import com.example.posts_app_new.CheckPosts;
import com.example.posts_app_new.DTO.PostDTO;
import com.example.posts_app_new.service.Impl.PostServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl postService;

    @GetMapping
    public ResponseEntity<Page<PostDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(postService.findAll(pageable));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<PostDTO>> filterPosts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String author,
            Pageable pageable){

        return ResponseEntity.ok(postService.filterPosts(category,author,pageable));

    }

    @GetMapping("/{idPost}")
    public ResponseEntity<PostDTO> findById(@PathVariable Long idPost){
        return ResponseEntity.ok(postService.findById(idPost));
    }

    @PostMapping
    public ResponseEntity<PostDTO> save(@Valid @RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.save(postDTO));
    }

    @PutMapping("/{idPost}")
    @CheckPosts
    public ResponseEntity<PostDTO> update(@PathVariable Long idPost, @Valid @RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.update(idPost, postDTO));
    }

    @DeleteMapping("/{idPost}")
    @CheckPosts
    public ResponseEntity<Void> deleteById(@PathVariable Long idPost){
        postService.deletePost(idPost);
        return ResponseEntity.noContent().build();
    }


}
