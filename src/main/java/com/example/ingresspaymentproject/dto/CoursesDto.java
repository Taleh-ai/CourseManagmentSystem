package com.example.ingresspaymentproject.dto;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CoursesDto {

  Long id;
  
  private String courseName;
  
  private boolean isActive;
}
