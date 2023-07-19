package com.example.ingresspaymentproject.controller;

import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CoursesService service;

    @PostMapping("/courses")
    public void addCourse(@RequestBody CoursesDto coursesDto){
        service.saveCourse(coursesDto);
    }
    @PutMapping("/courses")
    public void updateCourse(@RequestBody CoursesDto coursesDto){
        service.saveCourse(coursesDto);
    }
    @DeleteMapping("/courses/{name}")
    public void deleteCourse(@PathVariable("name") String name){
        service.deleteCourse(name);
    }
    @GetMapping("/courses/{name}")
    public CoursesDto getCourse(@PathVariable("name") String name) throws MethodArgumentNotValidException {
       return service.getCourse(name);
    }
    @GetMapping("/courses")
    public List<CoursesDto> getCourses() {
       return service.getAllCourses();
    }
}
