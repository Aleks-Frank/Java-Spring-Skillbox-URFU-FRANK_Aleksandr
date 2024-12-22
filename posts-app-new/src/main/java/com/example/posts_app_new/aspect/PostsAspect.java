package com.example.posts_app_new.aspect;

import com.example.posts_app_new.CheckPosts;
import com.example.posts_app_new.repository.CommentRepository;
import com.example.posts_app_new.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@RequiredArgsConstructor
public class PostsAspect {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    @Before("@annotation(com.example.posts_app_new.CheckPosts)")
    public void checkPosts(JoinPoint point){
        var requestAttribute = RequestContextHolder.getRequestAttributes();
        var request = ((ServletRequestAttributes) requestAttribute).getRequest();
        var currentNameUser = request.getParameter("user");
        var posts = postRepository.findById((Long) point.getArgs()[0]).orElseThrow(() -> new RuntimeException("Posts not found"));

        if (!posts.getUserAuthor().getNameUser().equals(currentNameUser)){
            throw new RuntimeException("Yon do not delete or edit this posts");
        }
    }

    @Before("@annotation(com.example.posts_app_new.CheckComments)")
    public void checkComments(JoinPoint point){
        var requestAttribute = RequestContextHolder.getRequestAttributes();
        var request = ((ServletRequestAttributes) requestAttribute).getRequest();
        var currentNameUser = request.getParameter("user");
        var comments = commentRepository.findById((Long) point.getArgs()[0]).orElseThrow(() -> new RuntimeException("Comments not found"));

        if (!comments.getUserAuthor().getNameUser().equals(currentNameUser)){
            throw new RuntimeException("Yon do not delete or edit this comments");
        }
    }

}
