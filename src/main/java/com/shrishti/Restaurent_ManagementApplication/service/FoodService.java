package com.shrishti.Restaurent_ManagementApplication.service;

import com.shrishti.Restaurent_ManagementApplication.model.Food;
import com.shrishti.Restaurent_ManagementApplication.repository.IFoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    IFoodDao foodDao;

    public String saveFood(List<Food> foods) {
        foodDao.saveAll(foods);
        return "FoodList is Saved!!!";
    }

    public String updateFood(Food food, Integer foodId) {
        Food oldFood = foodDao.findById(foodId).get();

        if(food != null){
            oldFood.setFoodName(food.getFoodName());
            oldFood.setPrice(food.getPrice());
            foodDao.save(oldFood);
            return oldFood.getFoodName() + "  is Updated!!!";
        }
        return "Given data is Null!!!";
    }

    public List<Food> getAllFood() {
        return foodDao.findAll();
    }
}
