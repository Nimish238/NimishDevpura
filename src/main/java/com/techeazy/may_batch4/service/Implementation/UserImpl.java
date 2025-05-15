package com.techeazy.may_batch4.service.Implementation;

import com.techeazy.may_batch4.entity.UserEntity;
import com.techeazy.may_batch4.model.UserModel;
import com.techeazy.may_batch4.repository.UserRepository;
import com.techeazy.may_batch4.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserModel userModel) {


        UserEntity newUser = new UserEntity(
                userModel.getID(),
                userModel.getName(),
                userModel.getEmail(),
                this.passwordEncoder.encode(userModel.getPassword())
        );


        userRepository.save(newUser);
        return newUser.getName();
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
