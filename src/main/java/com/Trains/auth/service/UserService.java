package com.Trains.auth.service;

import com.Trains.auth.model.User;
/**
 * 
 * @author laharipratap
 *
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
