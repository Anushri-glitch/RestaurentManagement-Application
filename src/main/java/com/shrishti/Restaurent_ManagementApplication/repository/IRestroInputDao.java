package com.shrishti.Restaurent_ManagementApplication.repository;

import com.shrishti.Restaurent_ManagementApplication.model.RestroSignInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestroInputDao extends JpaRepository<RestroSignInput,Integer> {
    public RestroSignInput findFirstByPassword(String password);
}
