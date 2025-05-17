package com.techeazy.may_batch4.service;

import com.techeazy.may_batch4.model.LoginModel;
import com.techeazy.may_batch4.model.UserModel;
import com.techeazy.may_batch4.response.LoginMessage;

import java.util.List;


public interface UserService {

    public String addUser(UserModel userModel);
    LoginMessage loginUser(LoginModel loginModel);
    UserModel getUserById(Integer userId);
    List<UserModel> getAllUsers();


}
