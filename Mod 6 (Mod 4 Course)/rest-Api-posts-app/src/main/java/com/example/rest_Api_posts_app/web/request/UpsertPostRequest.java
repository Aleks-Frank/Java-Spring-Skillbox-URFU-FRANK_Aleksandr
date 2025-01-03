package com.example.rest_Api_posts_app.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpsertPostRequest {

    @NotNull(message = "User ID cannot be empty")
    private Long userId;

    @NotBlank(message = "The post title cannot be empty")
    private String headLine;

    private String description;

    @NotBlank(message = "The post body cannot be empty")
    private String bodyLine;

    @NotBlank(message = "Post category name cannot be empty")
    private String categoryName;
}