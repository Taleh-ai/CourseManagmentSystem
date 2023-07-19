package com.example.ingresspaymentproject.entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "courses")
public class CoursesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(name = "course_name")
  private String courseName;
  @Column(name = "is_active")
  private boolean isActive;
}
