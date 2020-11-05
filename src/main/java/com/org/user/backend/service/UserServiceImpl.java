package com.org.user.backend.service;

import com.org.user.backend.model.User;
import com.org.user.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    // Переменная для генерации ID пользователя
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(User user) {
        final long userId = CLIENT_ID_HOLDER.incrementAndGet();
        user.setUserId(userId);
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User read(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public boolean update(User user, long id) {
        if (userRepository.existsById(id)) {
            user.setUserId(id);
            userRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
