package com.alina.web.productproject.services;

import com.alina.web.productproject.Forms.UserForm;
import com.alina.web.productproject.Forms.WhineForm;
import com.alina.web.productproject.models.User;
import com.alina.web.productproject.models.Whine;

import java.util.List;

public interface UsersService {
    void addUser(UserForm form);

    List<User> getAllUser();

    void deleteUser(Long userId);

    User getUser(Long userId);

    void update(Long userId, UserForm form);

    List<Whine> getWhinesByUser(Long userId);

    void addWhineToUser(Long userId, WhineForm form);

    List<Whine> getAllWhines();

    void deleteWhine(Long whineId, Long userId);
}
