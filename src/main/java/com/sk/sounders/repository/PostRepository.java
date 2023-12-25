package com.sk.sounders.repository;

import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    public ArrayList<Post> findAll();

    @Query("SELECT p FROM Post p ORDER BY p.id DESC")
    ArrayList<Post> findAllDesc();

    public Post findById(long id);

    public Post findByTitle(String title);

    public Post findByTitleAndAuthorAndId(String title, User author, long id);

    public List<Post> findByAuthor(User author);

    public Post save(Post post);

}
