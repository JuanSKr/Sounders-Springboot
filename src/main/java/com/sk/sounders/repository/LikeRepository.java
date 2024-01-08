package com.sk.sounders.repository;

import com.sk.sounders.entity.PostLike;
import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<PostLike, Long> {
    public List<PostLike> findByUser(User user);

    public List<PostLike> findByPost(Post post);

    public PostLike findById(long id);

    public PostLike findByPostAndUser(Post post, User user);

    public boolean existsByPostAndUser(Post post, User user);

    public long countByPost(Post post);
}
