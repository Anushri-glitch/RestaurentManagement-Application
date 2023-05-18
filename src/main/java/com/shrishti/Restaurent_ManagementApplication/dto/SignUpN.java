package com.shrishti.Restaurent_ManagementApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpN {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userContact;
}
