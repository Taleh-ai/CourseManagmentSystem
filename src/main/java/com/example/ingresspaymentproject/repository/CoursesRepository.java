package com.example.ingresspaymentproject.repository;

import com.example.ingresspaymentproject.entity.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CoursesRepository extends JpaRepository<CoursesEntity,Long> {
    void deleteByCourseName(String name);
    CoursesEntity findByCourseName(String name);
    CoursesEntity findCoursesEntitiesByCourseNameContainsIgnoreCase(String name);
    CoursesEntity getById(Long id);
}
