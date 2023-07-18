package com.example.ingresspaymentproject.repository;

import com.example.ingresspaymentproject.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    StudentEntity getStudentEntityByPhone(String phone);


    void deleteByPhone(String phone);
}
