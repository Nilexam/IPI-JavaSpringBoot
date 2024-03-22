package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.UserDao;
import com.ipi.championshipmanagement.pojos.User;
import com.ipi.championshipmanagement.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User getUserById(long userId) {
        Optional<User> optionalUser = userDao.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> optionalUser = Optional.ofNullable(userDao.findByEmail(email));
        return optionalUser.orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        Optional<User> optionalUser = Optional.ofNullable(userDao.findByLogin(login));
        return optionalUser.orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(long userId) {
        userDao.deleteById(userId);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public boolean emailExists(String email) {
        return userDao.existsByEmail(email) ;
    }

    @Override
    public boolean loginExists(String login) {
        return userDao.existsByLogin(login) ;
    }
}
