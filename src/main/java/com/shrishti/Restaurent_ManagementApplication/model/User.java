package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    //Example - Anushka1234 - dont use
    @Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
    @NotEmpty(message = "UserName is Empty!!!")
    private String userName;

    @NotEmpty(message = "password is Empty!!!")
    private String userPassword;

    //Example - Anushka12@gmail.com - dont use admin
    //@Pattern(regexp = "^[a-z0-9]{3,}@[a-z]{3,}[.]{1}[a-z]{3,}$")
    @NotEmpty(message = "Email is Empty!!!")
    private String userEmail = " ";

    //example - 1234567890
    @NotEmpty(message = "Phone Number is Empty!!!")
    @Size(min = 10, max = 12)
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{4,5}[-.]?\\d{5}$")
    private String userPhone;

//    @ManyToMany
//    @JoinColumn(name = "menu")
//    private List<Food> foodList = new ArrayList<>();

    public User(String userName, String userEmail, String userPassword, String userPhone) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
    }
}
