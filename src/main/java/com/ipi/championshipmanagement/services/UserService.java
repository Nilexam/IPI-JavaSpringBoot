package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long userId);

    User saveUser(User user);

    void deleteUser(long userId);

    User findByLogin(String login);
}