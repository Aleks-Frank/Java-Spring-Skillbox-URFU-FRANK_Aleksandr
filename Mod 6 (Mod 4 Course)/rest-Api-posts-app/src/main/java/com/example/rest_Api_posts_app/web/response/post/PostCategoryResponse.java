package com.example.rest_Api_posts_app.web.response.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCategoryResponse {

    private Long id;

    private String headLine;

    private Instant createdAt;

}
