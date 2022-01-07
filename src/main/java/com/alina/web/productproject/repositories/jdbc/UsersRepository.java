package com.alina.web.productproject.repositories.jdbc;

import com.alina.web.productproject.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();

    void save(User user);

    void delete(Long userId);

    User findById(Long userId);

    void updateById(Long userId, User user);
}
