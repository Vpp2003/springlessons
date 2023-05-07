package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User createUser(User user);
    User getCurrentUser();

}
