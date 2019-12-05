package com.example.simpleApp.controller;

import com.example.simpleApp.domain.User;
import com.example.simpleApp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public Iterable<User> userList( ){
        return userRepo.findAll();
    }
}
