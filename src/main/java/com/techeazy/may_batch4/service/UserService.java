package com.techeazy.may_batch4.service;

import com.techeazy.may_batch4.model.UserModel;

import java.util.List;


public interface UserService {

    public String addUser(UserModel userModel);

    UserModel getUserById(Integer userId);
    List<UserModel> getAllUsers();


}
