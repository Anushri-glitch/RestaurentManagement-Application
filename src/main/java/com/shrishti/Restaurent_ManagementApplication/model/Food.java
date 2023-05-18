package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;

    @Pattern(regexp = "^[a-z0-9]{3,}@[admin]{3,5}[.]{1}[com]{1,3}$", message = "Please Make Sure That You are admin user!!!")
    private String email;

    private String foodName;
    private Double price;
}

