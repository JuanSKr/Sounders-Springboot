package com.sk.sounders.repository;

import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    public ArrayList<Post> findAll();

    @Query("SELECT p FROM Post p ORDER BY p.id DESC")
    ArrayList<Post> findAllDesc();

    public Post findById(long id);

    public Post findByAuthorAndId(User author, long id);

    List<Post> findByAuthorOrderByIdDesc(User author);

    public Post save(Post post);

}
