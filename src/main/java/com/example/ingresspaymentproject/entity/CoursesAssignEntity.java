package com.example.ingresspaymentproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class CoursesAssignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "student")
    private String studentNumber;

    @Column(name = "is_active")
    private boolean isActive;
}
