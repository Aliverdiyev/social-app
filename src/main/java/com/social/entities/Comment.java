package com.social.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NotBlank(message = "comment text must not be empty")
    @Column(columnDefinition = "TEXT")
    private String commentText;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdCommentDate;

    // relationship between tables
// ManyToOne
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    // relationship between tables
    // OneToMany
    @OneToMany(mappedBy = "comment",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Like> likes;
}