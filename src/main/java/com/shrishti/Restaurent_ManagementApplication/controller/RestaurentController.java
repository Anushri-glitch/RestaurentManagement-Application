package com.shrishti.Restaurent_ManagementApplication.controller;

import com.shrishti.Restaurent_ManagementApplication.model.Management;
import com.shrishti.Restaurent_ManagementApplication.model.RestaurentData.R_Employee;
import com.shrishti.Restaurent_ManagementApplication.model.Restaurent;
import com.shrishti.Restaurent_ManagementApplication.model.RestroSignInput;
import com.shrishti.Restaurent_ManagementApplication.service.RestaurentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurentController {

    @Autowired
    RestaurentService restaurentService;

    //Create Restaurent or Registration
    @PostMapping(value = "/restaurent")
    public String createRestaurent(@Valid @RequestBody RestroSignInput restaurents){
        return restaurentService.createRestaurent(restaurents);
    }

    //User Service API - Get All Restaurents For User
    @GetMapping(value = "/userRestaurents")
    public List<Restaurent> getAllRestaurent(){
        return restaurentService.getAllRestaurents();
    }

    //Self-Service API - Restaurent to view own information
    @GetMapping(value = "/restaurent")
    public Restaurent findRestaurentById(@RequestParam Integer resId, @RequestParam String password){
        return restaurentService.findRestaurentById(resId,password);
    }

    //Self-Service API - Restaurent to Update its own information
    @PutMapping(value = "/restaurent")
    public String updateRestaurent(@RequestBody Restaurent restaurent, @RequestParam Integer resId){
        return restaurentService.updateRestaurent(restaurent,resId);
    }

    //Management Service - Create Employee
    @PostMapping(value = "/employee")
    public String createEmployee(@RequestBody R_Employee employee){
        return restaurentService.createEmployee(employee);
    }

    //Management Service - Create Management HR
    @PostMapping(value = "/management")
    public String createManagement(@RequestBody Management manage){
        return restaurentService.createManagement(manage);
    }

    //Management Service - Open Admin Portal By Id and Password
    @GetMapping(value = "/managementData")
    public Management findByIdAndPassword(@RequestParam Integer id, @RequestParam String password){
        return restaurentService.findByIdAndPassword(id,password);
    }
}
