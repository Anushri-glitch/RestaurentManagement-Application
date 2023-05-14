package com.shrishti.Restaurent_ManagementApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class RestroSignInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer resId;

    @Pattern(regexp = "^[A-Za-z]\\\\w{5,29}$")
    @NotEmpty(message = "RestaurentName is Empty!!!")
    private String restaurentName;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$")
    @NotEmpty(message = "Restaurent password is Empty!!!")
    private String password;
    private String restaurentPublicName;
    private String restaurentAdd;
    private String email;
    private String restaurentSpeciality;
    private Integer restaurentTotalStaff;
    private String restaurentPhone;
}
