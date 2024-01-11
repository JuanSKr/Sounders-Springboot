package com.sk.sounders.repository;

import com.sk.sounders.entity.Comment;
import com.sk.sounders.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public ArrayList<Comment> findAll();

    public Comment findById(long id);

    public ArrayList<Comment> findByPost(Post post);

    public Comment save(Comment comment);

    public void delete(Comment comment);

    public void deleteById(long id);

    public void deleteByPost(Post post);
}
