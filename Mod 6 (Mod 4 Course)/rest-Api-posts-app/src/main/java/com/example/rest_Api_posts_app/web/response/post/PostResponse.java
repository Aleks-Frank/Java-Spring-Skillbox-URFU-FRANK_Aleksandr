package com.example.rest_Api_posts_app.web.response.post;

import com.example.rest_Api_posts_app.web.response.comment.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private Long id;

    private String headLine;

    private String description;

    private String bodyLine;

    private String nameUser;

    private Instant createdAt;

    private Instant updatedAt;

    private Integer countComment;

    private List<CommentResponse> comments = new ArrayList<>();
}
