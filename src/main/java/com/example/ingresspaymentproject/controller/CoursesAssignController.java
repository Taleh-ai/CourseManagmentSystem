package com.example.ingresspaymentproject.controller;

import com.example.ingresspaymentproject.dto.CoursesAssignDto;
import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.service.impl.CoursesAssignServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoursesAssignController {
    private final CoursesAssignServiceImpl coursesAssignService;
    @PostMapping("/assign-course")
    public void addCourse(@RequestBody CoursesAssignDto coursesDto)  {
        coursesAssignService.assignCourse(coursesDto);
    }
    @PutMapping("/assign-course/{id}")
    public void updateCourse(@PathVariable("id") Long id , @RequestBody CoursesAssignDto coursesDto){
        coursesAssignService.updateCourse(id,coursesDto);
    }
    @GetMapping("/assign-course/{name}")
    public List<CoursesAssignDto> getCourse(@PathVariable("name") String name) throws MethodArgumentNotValidException {
        return coursesAssignService.getAllCourses(name);
    }

    @GetMapping("/assign-course")
    public List<CoursesAssignDto> getCourse() throws MethodArgumentNotValidException {
        return coursesAssignService.getAllCourses();
    }

}
