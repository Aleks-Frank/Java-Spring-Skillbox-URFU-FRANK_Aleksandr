package com.example.posts_app_new.DTO;

import lombok.Data;

@Data
public class CommentDTO {

    private Long id;

    private String comment;

    private String userAuthor;

    private Long idPost;

}
