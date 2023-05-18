package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.Admin;
import com.shrishti.Restaurent_ManagementApplication.model.AuthTokenAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminTokenDao extends JpaRepository<AuthTokenAdmin,Long> {
    AuthTokenAdmin findFirstByAdmin(Admin newUser);
}
