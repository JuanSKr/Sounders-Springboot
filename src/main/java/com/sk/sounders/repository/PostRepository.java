package com.sk.sounders.repository;

import com.sk.sounders.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PostRepository extends JpaRepository<Post, Long> {

    public ArrayList<Post> findAll();

    public Post findById(long id);

    public Post save(Post post);

}
