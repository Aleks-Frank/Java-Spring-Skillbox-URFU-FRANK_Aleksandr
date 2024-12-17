package com.example.rest_Api_posts_app.web.response.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsListResponse {

    private Long totalCount;

    private List<PostFindAllResponse> postResponseList = new ArrayList<>();
}
