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
    private Integer restaurentNewId;
    private String restaurentPublicName;
    private String restaurentUserName;
    private String restaurentAdd;
    private String email;
    private String restaurentPhone;
    private String restaurentSpeciality;
    private Integer restaurentTotalStaff;

    @ManyToMany
    @JoinColumn(name = "menu")
    private List<Food> menu = new ArrayList<>();
}
