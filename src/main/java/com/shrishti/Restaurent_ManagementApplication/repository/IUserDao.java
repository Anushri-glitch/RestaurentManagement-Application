package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.Management;
import com.shrishti.Restaurent_ManagementApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User,Integer> {
}
