package com.ride.springframework.services;

import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.Role;
import com.ride.springframework.domain.User;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by OD on 6/18/2017.
 */

public interface UserService {

    public User save(User user);

    User findByUsernameAndPassword(String username, String pasword);

    public User findUserbyId(Integer id);

    public User findByUsername(String username);

    public Integer findUserAddress(Integer id);

    public Role saveRole(Role role);

}