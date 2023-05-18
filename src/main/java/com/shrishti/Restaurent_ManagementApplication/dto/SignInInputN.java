package com.shrishti.Restaurent_ManagementApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInputN {

    private String userEmail;
    private String userPassword;
}
