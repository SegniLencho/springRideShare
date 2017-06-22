package com.ride.springframework.services;

import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.Role;
import com.ride.springframework.domain.User;
import com.ride.springframework.repositories.RoleRepository;
import com.ride.springframework.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

/**
 * Created by OD on 6/18/2017.
 */
@Service
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Integer findUserAddress(Integer id) {
        return userRepository.findaddressId(id);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findByUsernameAndPassword(String username,String pasword){
        return userRepository.findByUsernameAndPassword(username,pasword);
    }
    @Override
    public User findUserbyId(Integer id) {
        return userRepository.findOne(id);
    }
}



