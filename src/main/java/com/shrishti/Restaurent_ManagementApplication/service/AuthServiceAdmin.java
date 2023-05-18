package com.shrishti.Restaurent_ManagementApplication.service;

import com.shrishti.Restaurent_ManagementApplication.model.Admin;
import com.shrishti.Restaurent_ManagementApplication.model.AuthTokenAdmin;
import com.shrishti.Restaurent_ManagementApplication.repository.IAdminTokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceAdmin {

    @Autowired
    IAdminTokenDao adminTokenDao;

    public void saveToken(AuthTokenAdmin token) {
        adminTokenDao.save(token);
    }

    public AuthTokenAdmin getToken(Admin newUser) {
        return adminTokenDao.findFirstByAdmin(newUser);
    }
}
