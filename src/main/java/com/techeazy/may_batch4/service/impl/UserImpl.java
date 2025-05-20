package com.techeazy.may_batch4.service.impl;


import com.techeazy.may_batch4.entity.UserEntity;
import com.techeazy.may_batch4.model.UserModel;
import com.techeazy.may_batch4.repository.UserRepository;
import com.techeazy.may_batch4.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public String addUser(UserModel userModel) {

        UserEntity newUser = new UserEntity();
        newUser.setName(userModel.getName());
        newUser.setEmail(userModel.getEmail());
        newUser.setRole(userModel.getRole());
        newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(newUser);
        return String.valueOf(newUser);
    }


    @Override
    public UserModel getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return null;
    }
}
