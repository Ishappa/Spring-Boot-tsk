package com.ish.spring_sec_1.service;

import com.ish.spring_sec_1.dao.UserRepo;
import com.ish.spring_sec_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepo repo;

    public User addUser(User user){
        return repo.save(user);
    }
}
