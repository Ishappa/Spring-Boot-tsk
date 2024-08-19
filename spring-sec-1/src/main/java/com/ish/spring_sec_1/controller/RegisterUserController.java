package com.ish.spring_sec_1.controller;

import com.ish.spring_sec_1.model.User;
import com.ish.spring_sec_1.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserController {

    @Autowired
    private RegisterUserService service;
    @PostMapping("register")
    public User register(@RequestBody User user){
     return service.addUser(user);
    }
}
