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
public class UpdateCommentAspect {

    private final CommentService commentService;

    @Around("@annotation(AccessibleUpdateComment)")
    public Object userControlUpdateCommentAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();

        Comment updateComment = (Comment) args[0];
        Long updateUserId = updateComment.getUser().getId();
        Long updateCommentId = updateComment.getId();
        Comment comment = commentService.findById(updateCommentId);
        if (comment.getUser().getId().equals(updateUserId)) {
            return proceedingJoinPoint.proceed(args);
        }

        throw new AccessibleException("User is not allowed to update this comment");
    }
}