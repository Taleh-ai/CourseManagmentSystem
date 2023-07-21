package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.CoursesAssignDto;
import com.example.ingresspaymentproject.dto.CoursesDto;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public interface CoursesAssignService {

    public void assignCourse(CoursesAssignDto coursesAssignDto) ;
    public void updateCourse(Long id,CoursesAssignDto  coursesAssignDto);

    public List<CoursesAssignDto> getAllCourses(String name);

    public List<CoursesAssignDto> getAllCourses();

}
