package com.techeazy.may_batch4.rest;

import com.techeazy.may_batch4.model.UserModel;
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
    UserService userService;

    @PostMapping(value = "/save")
    public String saveEmployee(@RequestBody UserModel userModel){

        userService.addUser(userModel);
        return String.valueOf(ResponseEntity.ok( "User Created"));

    }

}
