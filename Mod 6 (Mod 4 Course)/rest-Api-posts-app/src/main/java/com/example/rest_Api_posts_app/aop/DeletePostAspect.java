package com.example.rest_Api_posts_app.aop;

import com.example.rest_Api_posts_app.exeption.AccessibleException;
import com.example.rest_Api_posts_app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.example.rest_Api_posts_app.model.Post;

@Aspect
@Component
@RequiredArgsConstructor
public class DeletePostAspect {
    private final PostService postService;

    @Around("@annotation(AccessibleDeletePost)")
    public Object userControlDeleteNewsAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();

        Long postId = (Long) args[0];
        Long userId = (Long) args[1];
        Post deletingPost = postService.findById(postId);
        if (deletingPost.getUser().getId().equals(userId)) {
            return proceedingJoinPoint.proceed(args);
        }
        throw new AccessibleException("User is not allowed to delete this post");
    }
}
