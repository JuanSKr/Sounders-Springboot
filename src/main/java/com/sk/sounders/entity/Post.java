package com.sk.sounders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(nullable = false)
    private String spotify;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Long likes = 0L;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;


}
