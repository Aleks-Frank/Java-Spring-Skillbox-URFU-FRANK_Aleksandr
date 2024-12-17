package com.example.rest_Api_posts_app.repository;

import com.example.rest_Api_posts_app.model.Category;
import com.example.rest_Api_posts_app.model.Post;
import com.example.rest_Api_posts_app.model.User;
import com.example.rest_Api_posts_app.web.request.PostFilterRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public interface SpecialPost {

    static Specification<Post> withFilter(PostFilterRequest filter){
        return Specification.where(
                byCategoryName(filter.getCategoryName()))
                        .and(byNameUser(filter.getNameUser()));
    }

    static Specification<Post> byNameUser(String username) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(username)) {
                return null;
            }
            return criteriaBuilder.equal(root.get(Post.Fields.user).get(User.Fields.nameUser), username);
        };
    }

    static Specification<Post> byCategoryName(String categoryName) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(categoryName)) {
                return null;
            }

            return criteriaBuilder.equal(root.get(Post.Fields.category).get(Category.Fields.nameCategory), categoryName);
        };
    }

}
