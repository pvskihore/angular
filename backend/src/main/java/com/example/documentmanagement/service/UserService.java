package com.example.documentmanagement.service;

import com.example.documentmanagement.model.User;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> findByUsername(String username);
}
