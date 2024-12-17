package com.example.rest_Api_posts_app.web.response.category;

import com.example.rest_Api_posts_app.web.response.post.PostCategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private Long id;

    private String nameCategory;

    private List<PostCategoryResponse> posts = new ArrayList<>();

}
