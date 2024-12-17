package com.example.rest_Api_posts_app.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@ToString
@FieldNameConstants
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String headLine;

    private String description;

    @Column(nullable = false)
    private String bodyLine;

    @CreationTimestamp
    private Instant createAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, updatable = false)
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    @ToString.Exclude
    private Category category;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment){
        comment.setPost(this);
        comments.add(comment);
    }

}
