package com.dao;

import com.entity.User;


import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
}
