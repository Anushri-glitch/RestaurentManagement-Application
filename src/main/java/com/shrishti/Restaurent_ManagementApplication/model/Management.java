package com.shrishti.Restaurent_ManagementApplication.model;

import com.shrishti.Restaurent_ManagementApplication.model.RestaurentData.R_Employee;
import com.shrishti.Restaurent_ManagementApplication.model.RestaurentData.R_Reporting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hrId;
    private String hrName;
    private String hrPassword;

    @OneToOne
    private Restaurent restaurentName;

    @OneToOne
    private R_Employee employees;

    @OneToOne(cascade = CascadeType.ALL)
    private R_Reporting report;
}
