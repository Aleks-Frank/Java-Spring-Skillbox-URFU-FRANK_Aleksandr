package com.example.rest_Api_posts_app.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @CreationTimestamp
    private Instant createAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_post")
    @ToString.Exclude
    private Post post;

}
