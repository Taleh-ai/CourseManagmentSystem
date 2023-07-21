package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public void saveStudent(StudentDto studentDto);
    public void updateStudent(Long id,StudentDto studentDto);

    public  void deleteStudent(String number);

    public StudentDto getStudent(String number);
    public List<StudentDto> getAllStudent();
}
