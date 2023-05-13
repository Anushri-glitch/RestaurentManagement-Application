package com.shrishti.Restaurent_ManagementApplication.controller;

import com.shrishti.Restaurent_ManagementApplication.model.User;
import com.shrishti.Restaurent_ManagementApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //Create User
    @PostMapping(value = "/user")
    public String saveUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }
}
