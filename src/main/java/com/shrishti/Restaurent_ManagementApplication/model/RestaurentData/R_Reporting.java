package com.shrishti.Restaurent_ManagementApplication.model.RestaurentData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
public class R_Reporting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reportId;
    private String restaurentAttendence;
    private String restaurentPerformance;
    private List<String> reviews;
}
