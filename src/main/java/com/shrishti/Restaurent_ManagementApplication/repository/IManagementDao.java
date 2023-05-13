package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManagementDao extends JpaRepository<Management, Integer> {
    public Management findByIdAndPassword(Integer hrId, String password);
}
