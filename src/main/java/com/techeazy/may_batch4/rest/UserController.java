package com.techeazy.may_batch4.rest;

import com.techeazy.may_batch4.model.LoginModel;
import com.techeazy.may_batch4.model.UserModel;
import com.techeazy.may_batch4.response.LoginMessage;
import com.techeazy.may_batch4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String saveEmployee(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel){
        LoginMessage loginMessage = userService.loginUser(loginModel);
        return ResponseEntity.ok(loginMessage);
    }

}
