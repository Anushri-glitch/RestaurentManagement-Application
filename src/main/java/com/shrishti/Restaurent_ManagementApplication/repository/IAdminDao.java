package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminDao extends JpaRepository<Admin, Integer> {
    Admin existsByAdminEmail(String user);

    Admin findFirstByAdminEmail(String adminUserEmail);
}
