package com.sk.sounders.service.impl;

import com.sk.sounders.entity.Post;
import com.sk.sounders.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostServiceImpl {

    @Autowired
    PostRepository postRepository;

    public ArrayList<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(long id) {
        return postRepository.findById(id);
    }

    public Post findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void deleteById(long id) {
        postRepository.deleteById(id);
    }

    public ArrayList<Post> findAllDesc() {
        return postRepository.findAllDesc();
    }


}
