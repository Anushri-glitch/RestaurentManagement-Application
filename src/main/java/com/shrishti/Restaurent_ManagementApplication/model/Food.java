package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;
    private String foodName;
    private Double price;

    @ManyToOne
    private Restaurent restaurent;
}

