package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.exception.MethodArgumentNotValidException;

import java.util.List;

public interface  CoursesService {
    public void saveCourse(CoursesDto courseDto) throws com.example.ingresspaymentproject.exception.MethodArgumentNotValidException;
    public void updateCourse(Long id,CoursesDto  courseDto) throws MethodArgumentNotValidException;

    public  void deleteCourse(String name);

    public List<CoursesDto> getAllCourses();
}
