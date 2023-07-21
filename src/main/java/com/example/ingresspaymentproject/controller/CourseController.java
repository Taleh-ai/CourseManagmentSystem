package com.example.ingresspaymentproject.controller;

import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.exception.MethodArgumentNotValidException;
import com.example.ingresspaymentproject.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CoursesService service;

    @PostMapping("/courses")
    public void addCourse(@RequestBody CoursesDto coursesDto) throws com.example.ingresspaymentproject.exception.MethodArgumentNotValidException {
        service.saveCourse(coursesDto);
    }
    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable("id") Long id ,@RequestBody CoursesDto coursesDto) throws MethodArgumentNotValidException {
        service.updateCourse(id,coursesDto);
    }
    @DeleteMapping("/courses/{name}")
    public void deleteCourse(@PathVariable("name") String name){
        service.deleteCourse(name);
    }
    @GetMapping("/courses")
    public List<CoursesDto> getCourses() {
       return service.getAllCourses();
    }
}
