package com.shrishti.Restaurent_ManagementApplication.controller;
import com.shrishti.Restaurent_ManagementApplication.dto.SignInInputA;
import com.shrishti.Restaurent_ManagementApplication.dto.SignInInputN;
import com.shrishti.Restaurent_ManagementApplication.dto.SignUpOutput;
import com.shrishti.Restaurent_ManagementApplication.model.Admin;
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
    @PostMapping(value = "/normalUserSignUp")
    public SignUpOutput saveUser(@Valid @RequestBody User user){
        return userService.saveNormalUser(user);
    }

    @PostMapping(value = "/adminUserSignUp")
    public SignUpOutput saveUser(@Valid @RequestBody Admin user){
        return userService.saveAdminUser(user);
    }

    @PostMapping(value = "/signInN")
    public SignUpOutput signIn (@RequestBody SignInInputN signInDto){
        return userService.signIn(signInDto);
    }

    @PostMapping(value = "/signInA")
    public SignUpOutput signIn ( @Valid @RequestBody SignInInputA signInDto){
        return userService.signIn(signInDto);
    }
}
