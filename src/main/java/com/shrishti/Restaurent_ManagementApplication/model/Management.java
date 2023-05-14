package com.shrishti.Restaurent_ManagementApplication.model;

import com.shrishti.Restaurent_ManagementApplication.model.RestaurentData.R_Employee;
import com.shrishti.Restaurent_ManagementApplication.model.RestaurentData.R_Reporting;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table
@Entity
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hrId;
    private String hrName;
    private String hrPassword;

    @OneToOne
    @JoinColumn(name = "restaurent")
    private Restaurent restaurentName;

    @ManyToMany
    private List<R_Employee> employees = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private R_Reporting report;
}
