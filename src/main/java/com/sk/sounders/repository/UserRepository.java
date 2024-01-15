package com.sk.sounders.repository;

import com.sk.sounders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findById(long id);

    User findByUsername(String username);

    List<User> findAll();


}
