package com.example.ingresspaymentproject.service;

public interface  CoursesService {
    public void saveCourse(CoursesDto  courseDto);
    public void updateCourse(CoursesDto  courseDto);

    public  void deleteCourse(String name);

    public CoursesDto getCourse(String name);
    public List<CoursesDto> getAllCourses();
}
