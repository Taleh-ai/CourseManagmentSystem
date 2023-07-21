package com.example.ingresspaymentproject.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CoursesAssignDto {

    Long id;

    private String courseName;

    @Pattern(regexp="^\\+994\\d{9}$", message="Invalid number format!")
    private String studentNumber;

    private boolean isActive;
}
