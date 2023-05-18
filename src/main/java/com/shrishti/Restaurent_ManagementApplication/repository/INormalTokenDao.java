package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.AuthTokenNormal;
import com.shrishti.Restaurent_ManagementApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INormalTokenDao extends JpaRepository<AuthTokenNormal,Long> {
    AuthTokenNormal findFirstByUser(User aUser);
}
