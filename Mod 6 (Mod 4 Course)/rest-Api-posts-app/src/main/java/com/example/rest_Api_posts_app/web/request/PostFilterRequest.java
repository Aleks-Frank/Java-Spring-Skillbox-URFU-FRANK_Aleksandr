package com.example.rest_Api_posts_app.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFilterRequest {

    private Integer pageSize;

    private Integer pageNumber;

    private String categoryName;

    private String nameUser;
}