package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.RestaurentData.R_Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDao extends JpaRepository<R_Employee,Integer> {
}
