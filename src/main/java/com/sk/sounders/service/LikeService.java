package com.sk.sounders.service;

import com.sk.sounders.entity.PostLike;
import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;

    public PostLike findById(long id){
        return likeRepository.findById(id);
    }

    public PostLike save(PostLike like){
        likeRepository.save(like);
        return like;
    }

    public PostLike findByPostAndUser(Post post, User user){
        return likeRepository.findByPostAndUser(post, user);
    }

    public boolean existsByPostAndUser(Post post, User user){
        return likeRepository.existsByPostAndUser(post, user);
    }

    public boolean activePostAndUser(Post post, User user){
        PostLike like=this.findByPostAndUser(post, user);
        return like!=null && like.isState();
    }

    public long countByPost(Post post){
        return likeRepository.countByPost(post);
    }
}
