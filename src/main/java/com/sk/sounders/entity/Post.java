package com.sk.sounders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Transient
    private MultipartFile image;

    @Column(columnDefinition = "TEXT")
    private String imagePath;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime hour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Formula(value = "(SELECT COUNT(*) FROM post_like m WHERE m.post_id=id AND m.state=true)")
    private long numLikes;

    @Transient
    private boolean actualLike;

    public Post() {
        actualLike = false;
    }

    public Post(String text, User author, LocalDate date, LocalTime hour) {
        this.text = text;
        this.author = author;
        this.date = date;
        this.hour = hour;
    }

}
