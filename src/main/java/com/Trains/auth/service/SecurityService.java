package com.Trains.auth.service;
/**
 * 
 * @author laharipratap
 *
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
