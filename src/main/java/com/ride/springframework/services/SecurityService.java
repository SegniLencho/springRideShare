package com.ride.springframework.services;

/**
 * Created by OD on 6/20/2017.
 */
public interface SecurityService {
    public String findLoggedInUsername();
    public void autologin(String username, String password);
}
