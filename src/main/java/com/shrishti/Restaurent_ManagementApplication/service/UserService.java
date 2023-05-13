package com.shrishti.Restaurent_ManagementApplication.service;

import com.shrishti.Restaurent_ManagementApplication.model.User;
import com.shrishti.Restaurent_ManagementApplication.repository.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserDao userDao;
    public String saveUser(User user) {
        userDao.save(user);
        return user.toString();
    }
}
