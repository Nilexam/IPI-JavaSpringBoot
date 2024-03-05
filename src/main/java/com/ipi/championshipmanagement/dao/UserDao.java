package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
