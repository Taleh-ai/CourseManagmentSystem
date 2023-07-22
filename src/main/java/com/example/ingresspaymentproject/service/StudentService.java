package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.StudentDto;
import com.example.ingresspaymentproject.exception.MethodArgumentNotValidException;

import java.util.List;

public interface StudentService {

    public void saveStudent(StudentDto studentDto) throws MethodArgumentNotValidException;
    public void updateStudent(Long id,StudentDto studentDto);

    public  void deleteStudent(String number);

    public StudentDto getStudent(String number);
    public List<StudentDto> getAllStudent();
}
