package com.techeazy.may_batch4.rest;

import com.techeazy.may_batch4.Security.JWTHelper;
import com.techeazy.may_batch4.Security.JWTRequest;
import com.techeazy.may_batch4.Security.JWTResponse;
import com.techeazy.may_batch4.model.UserModel;

import com.techeazy.may_batch4.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;


    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public String saveEmployee(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest jwtAuthRequest) {

        this.authenticate(jwtAuthRequest.getEmail(), jwtAuthRequest.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthRequest.getEmail());
        String token = this.jwtHelper.generateToken(userDetails);

        JWTResponse response = new JWTResponse();
        response.setToken(token);
        response.setUserName(userDetails.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    private void authenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email,password);
        try{
            authManager.authenticate(authentication);
        }
        catch (BadCredentialsException e){
            throw new BadCredentialsException("Invalid Username or password!!");
        }
    }


    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(){
        throw new BadCredentialsException("Invalid username or password");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, you are authenticated!");
    }



}
