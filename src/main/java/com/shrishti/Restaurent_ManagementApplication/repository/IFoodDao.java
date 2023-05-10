package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodDao extends JpaRepository<Food,Integer> {
}
