package com.sk.sounders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime date;

    public Message() {
        date = LocalDateTime.now();
    }

    public Message(User sender, User receiver, String content) {
        this.date = LocalDateTime.now();
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
}
