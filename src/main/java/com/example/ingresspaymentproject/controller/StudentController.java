package com.example.ingresspaymentproject.controller;


import com.example.ingresspaymentproject.dto.StudentDto;
import com.example.ingresspaymentproject.service.impl.StudentServiceImpl;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
private  final StudentServiceImpl studentService;
    @GetMapping("/student/{number}")
    public StudentDto getStudent(@PathVariable @Pattern(regexp="^\\+994\\d{9}$") String number){
    return studentService.getStudent(number);
    }

    @GetMapping("/student")
    public List<StudentDto> getStudents(){
        return studentService.getAllStudent();
    }

    @PostMapping("/student")
    public void saveStudent(@RequestBody StudentDto studentDto){
        studentService.saveStudent(studentDto);
    }

    @PutMapping("/student")
    public void updateStudent(@RequestBody StudentDto studentDto){
        studentService.updateStudent(studentDto);
    }
}
