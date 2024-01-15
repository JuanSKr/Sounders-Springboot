package com.sk.sounders.repository;

import com.sk.sounders.entity.Message;
import com.sk.sounders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    public Message findById(long id);

    public List<Message> findBySenderAndReceiver(User sender, User receiver);

    @Query(
            value = "SELECT * FROM USERS u WHERE u.status = 1",
            nativeQuery = true)
    Collection<User> findAllActiveUsersNative();

    List<Message> findByReceiver(User receiver);

}
