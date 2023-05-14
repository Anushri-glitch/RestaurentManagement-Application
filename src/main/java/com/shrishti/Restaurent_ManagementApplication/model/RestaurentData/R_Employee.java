package com.shrishti.Restaurent_ManagementApplication.model.RestaurentData;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Table
@Entity
public class R_Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    private String employeeName;
    private String employeeJobRole;
    private Long employeeSalary;
    private LocalDateTime employeeTiming;
    private Long duration;
    private String employeePhone;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-] + (?:\\\\.[a-zA-Z0-9_+&*-]\n" +
            "+ )*@(?:[a-zA-Z0-9-]+\\\\.) + [a-zA-Z]{2, 7}$ ")
    @NotEmpty(message = "Employee Email is Empty!!!")
    private String employeeEmail;
}
