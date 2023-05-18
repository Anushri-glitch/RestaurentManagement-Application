package com.shrishti.Restaurent_ManagementApplication.service;

import com.shrishti.Restaurent_ManagementApplication.model.AuthTokenNormal;
import com.shrishti.Restaurent_ManagementApplication.model.User;
import com.shrishti.Restaurent_ManagementApplication.repository.INormalTokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceNormal {

    @Autowired
    INormalTokenDao normalTokenDao;
    public void saveToken(AuthTokenNormal token) {
        normalTokenDao.save(token);
    }


    public AuthTokenNormal getToken(User newUser) {
        return normalTokenDao.findFirstByUser(newUser);
    }
}
