package com.sk.sounders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    private boolean state;

    public PostLike() {
        state = true;
    }
}
