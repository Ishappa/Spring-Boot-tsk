package com.ish.spring_sec_1.service;

import com.ish.spring_sec_1.dao.UserRepo;
import com.ish.spring_sec_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepo repo;

    // while registering user make password saving as encoded.
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User addUser(User user){
       user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);
    }

}
