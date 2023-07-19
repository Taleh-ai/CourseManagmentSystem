package com.example.ingresspaymentproject.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CoursesDto {

  Long id;
  
  private String courseName;
  
  private boolean isActive;
}
