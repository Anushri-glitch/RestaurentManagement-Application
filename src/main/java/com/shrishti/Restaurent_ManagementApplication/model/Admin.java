package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminUserId;

    @Pattern(regexp = "^[A-Za-z]\\\\w{5,29}$")
    @NotEmpty(message = "UserName is Empty!!!")
    private String adminUserName;

    @NotEmpty(message = "password is Empty!!!")
    private String adminPassword;

    @Pattern(regexp = "^[a-z0-9]{3,}@[admin]{3,5}[.]{1}[com]{1,3}$")
    @NotEmpty(message = "Email is Empty!!!")
    private String adminEmail;

    @Pattern(regexp = "^(\\\\+\\\\d{1,3}( )?)?((\\\\(\\\\d{1,3}\\\\))|\\\\d{1,3})[- .]?\\\\d{3,4}[- .]?\\\\d{4}$")
    @NotEmpty(message = "Phone Number is Empty!!!")
    private String adminPhone;

//    @ManyToMany
//    @JoinColumn(name = "menu")
//    private List<Food> foodList = new ArrayList<>();

    public Admin(String adminUserName, String adminPassword, String adminEmail, String adminPhone) {
        this.adminUserName = adminUserName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
    }
}

