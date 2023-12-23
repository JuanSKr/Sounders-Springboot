package com.sk.sounders.service;

import com.sk.sounders.dto.UserDto;
import com.sk.sounders.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    User findByUsername(String username);

    List<UserDto> findAllUsers();
}
