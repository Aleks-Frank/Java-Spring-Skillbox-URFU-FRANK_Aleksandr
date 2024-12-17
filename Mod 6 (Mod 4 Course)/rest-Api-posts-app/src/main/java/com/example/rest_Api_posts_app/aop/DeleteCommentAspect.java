package com.example.rest_Api_posts_app.aop;

import com.example.rest_Api_posts_app.exeption.AccessibleException;
import com.example.rest_Api_posts_app.model.Comment;
import com.example.rest_Api_posts_app.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class DeleteCommentAspect {

    private final CommentService commentService;

    @Around("@annotation(AccessibleDeleteComment)")
    public Object userControlDeleteCommentAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();

        Long commentId = (Long) args[0];
        Long userId = (Long) args[1];
        Comment deletingComment = commentService.findById(commentId);
        if (deletingComment.getUser().getId().equals(userId)) {
            return proceedingJoinPoint.proceed(args);
        }
        throw new AccessibleException("User is not allowed to delete this comment");
    }
}