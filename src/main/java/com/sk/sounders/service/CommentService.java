package com.sk.sounders.service;

import com.sk.sounders.entity.Comment;
import com.sk.sounders.entity.Post;
import com.sk.sounders.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public ArrayList<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment findById(long id){
        return commentRepository.findById(id);
    }

    public ArrayList<Comment> findByPost(Post post){
        return commentRepository.findByPost(post);
    }

    public ArrayList<Comment> findByPostOrderByIdDesc(Post post){
        return commentRepository.findByPostOrderByIdDesc(post);
    }

    public Comment save(Comment comment){
        commentRepository.save(comment);
        return comment;
    }

    public void delete(Comment comment){
        commentRepository.delete(comment);
    }

    public void deleteById(long id){
        commentRepository.deleteById(id);
    }

    public void deleteByPost(Post post){
        commentRepository.deleteByPost(post);
    }

}
