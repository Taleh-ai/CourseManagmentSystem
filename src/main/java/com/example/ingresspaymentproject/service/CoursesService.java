package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.CoursesDto;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public interface  CoursesService {
    public void saveCourse(CoursesDto courseDto);
    public void updateCourse(CoursesDto  courseDto);

    public  void deleteCourse(String name);

    public CoursesDto getCourse(String name) throws MethodArgumentNotValidException;
    public List<CoursesDto> getAllCourses();
}
