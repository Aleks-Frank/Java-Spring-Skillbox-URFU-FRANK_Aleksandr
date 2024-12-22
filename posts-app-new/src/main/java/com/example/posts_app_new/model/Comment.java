package com.example.posts_app_new.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "commentsTable")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_user_author")
    private User userAuthor;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;

}
