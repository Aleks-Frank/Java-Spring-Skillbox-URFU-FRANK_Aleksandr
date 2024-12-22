package com.example.posts_app_new.DTO;

import lombok.Data;

@Data
public class PostDTO {

    private Long id;

    private String headLine;

    private String bodeLine;

    private String userAuthor;

    private String category;

    private int countComment;

}
