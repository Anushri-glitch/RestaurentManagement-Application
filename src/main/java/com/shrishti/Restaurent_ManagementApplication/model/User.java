package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]\\\\w{5,29}$")
    @NotEmpty(message = "UserName is Empty!!!")
    private String userName;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}$")
    @NotEmpty(message = "password is Empty!!!")
    private String password;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-] + (?:\\\\.[a-zA-Z0-9_+&*-]\n" +
            "+ )*@(?:[a-zA-Z0-9-]+\\\\.) + [a-zA-Z]{2, 7}$ ")
    @NotEmpty(message = "Email is Empty!!!")
    private String email;

    @NotNull
    @Pattern(regexp = "^(\\\\+\\\\d{1,3}( )?)?((\\\\(\\\\d{1,3}\\\\))|\\\\d{1,3})[- .]?\\\\d{3,4}[- .]?\\\\d{4}$")
    @NotEmpty(message = "Phone Number is Empty!!!")
    private String phone;

}
