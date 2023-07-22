package com.example.ingresspaymentproject.controller;


import com.example.ingresspaymentproject.dto.StudentDto;
import com.example.ingresspaymentproject.exception.MethodArgumentNotValidException;
import com.example.ingresspaymentproject.service.impl.StudentServiceImpl;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
private  final StudentServiceImpl studentService;
    @GetMapping("/students/{number}")
    public StudentDto getStudent(@PathVariable String number){
    return studentService.getStudent(number);
    }

    @GetMapping("/students")
    public List<StudentDto> getStudents(){
        return studentService.getAllStudent();
    }

    @PostMapping("/students")
    public void saveStudent(@RequestBody StudentDto studentDto) throws MethodArgumentNotValidException {
        studentService.saveStudent(studentDto);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Long id,@RequestBody StudentDto studentDto){
        studentService.updateStudent(id,studentDto);
    }
}
