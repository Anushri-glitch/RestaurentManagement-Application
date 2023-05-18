package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "^[A-Za-z]\\\\w{5,29}$")
    @NotEmpty(message = "UserName is Empty!!!")
    private String userName;

    @NotEmpty(message = "password is Empty!!!")
    private String userPassword;

    @Pattern(regexp = "^[a-zA-Z0-9_+&*-] + (?:\\\\.[a-zA-Z0-9_+&*-]\n" +
            "+ )*@(?:[a-zA-Z0-9-]+\\\\.) + [a-zA-Z]{2,7}$ ")
    @NotEmpty(message = "Email is Empty!!!")
    private String userEmail;

    @Pattern(regexp = "^(\\\\+\\\\d{1,3}( )?)?((\\\\(\\\\d{1,3}\\\\))|\\\\d{1,3})[- .]?\\\\d{3,4}[- .]?\\\\d{4}$")
    @NotEmpty(message = "Phone Number is Empty!!!")
    private String userPhone;

    @ManyToMany
    @JoinColumn(name = "menu")
    private List<Food> foodList = new ArrayList<>();

    public User(Integer userId, String userName, String userPassword, String userEmail, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }
}
