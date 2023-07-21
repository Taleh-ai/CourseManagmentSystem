package com.example.ingresspaymentproject.repository;

import com.example.ingresspaymentproject.entity.CoursesAssignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesAssignRepository extends JpaRepository<CoursesAssignEntity,Long> {

    List<CoursesAssignEntity> getAllByCourseNameContainsIgnoreCase(String name);
}
