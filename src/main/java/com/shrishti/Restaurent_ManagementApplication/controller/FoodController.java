package com.shrishti.Restaurent_ManagementApplication.controller;
import org.springframework.web.bind.annotation.RestController;
import com.shrishti.Restaurent_ManagementApplication.model.Food;
import com.shrishti.Restaurent_ManagementApplication.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    //Save Food List
    @PostMapping(value = "/food")
    public String saveFood(@RequestBody List<Food> foods){
        return foodService.saveFood(foods);
    }

    //Restaurent Self-Service : Restaurent to update foodList
    @PutMapping(value = "/food/{id}")
    public String updateFood(@RequestBody Food food, @PathVariable Integer foodId){
        return foodService.updateFood(food,foodId);
    }

    //Get List Of Food
    @GetMapping(value = "/AllFood")
    public List<Food> getAllFood(){
        return foodService.getAllFood();
    }
}
