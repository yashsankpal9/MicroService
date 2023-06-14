package com.micro.user.service.UserSerivce.services;

import com.micro.user.service.UserSerivce.Entites.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
