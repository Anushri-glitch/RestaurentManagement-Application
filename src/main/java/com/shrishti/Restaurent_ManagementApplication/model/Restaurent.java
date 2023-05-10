package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Restaurent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurentId;
    private String restaurentName;
    private String restaurentAdd;
    private Integer restaurentPhone;
    private String restaurentSpeciality;
    private Integer restaurentTotalstaff;

    @ManyToMany
    @JoinColumn(name = "food_name")
    List<Food> foodList = new ArrayList<>();
}
