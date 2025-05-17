package com.techeazy.may_batch4.service.Implementation;

import com.techeazy.may_batch4.entity.UserEntity;
import com.techeazy.may_batch4.model.LoginModel;
import com.techeazy.may_batch4.model.UserModel;
import com.techeazy.may_batch4.repository.UserRepository;
import com.techeazy.may_batch4.response.LoginMessage;
import com.techeazy.may_batch4.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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
    UserModel userModel;
    @Override
    public LoginMessage loginUser(LoginModel loginModel) {
        UserEntity user1 = userRepository.findByEmail(loginModel.getEmail());
        if(user1!=null){
            String password = loginModel.getPassword();
            String ePassword = user1.getPassword();
            boolean checkPassword = passwordEncoder.matches(password,ePassword);
            if(checkPassword){
                Optional<UserEntity> user = userRepository.findByEmailAndPassword(loginModel.getEmail(), ePassword);
                if(user.isPresent()){
                    return new LoginMessage("Login success!!",true);
                }
                else {
                    return new LoginMessage("Login failed!!", false);
                }
            }
            else{
                return new LoginMessage("Password does not match!!",false);
            }
        }
        else{
            return new LoginMessage("Email does not match",false);
        }
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
