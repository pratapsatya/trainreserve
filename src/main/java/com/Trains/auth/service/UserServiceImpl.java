package com.Trains.auth.service;

import com.Trains.auth.model.User;
import com.Trains.auth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * This is used to
 * - bcrypt the password and enter the user details into the database
 * -to get the user details*/

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
   
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * This method persists the information provided by the user.
     * @param user is the User pojo that has to be persisted 
     */

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       
        userRepository.save(user);
    }
    /**
     * This method is used to find user based on username
     * @param username is the username of the user
     * @return User object is returned
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
