package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.StudentDto;
import com.example.ingresspaymentproject.entity.StudentEntity;
import com.example.ingresspaymentproject.mapper.StudentMapper;
import com.example.ingresspaymentproject.repository.StudentRepository;
import com.example.ingresspaymentproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    @Override
    public void saveStudent(StudentDto studentDto) {
        StudentEntity entity = studentMapper.fromDto(studentDto);
        studentRepository.save(entity);
    }

    @Override
    public void updateStudent(Long id,StudentDto studentDto) {
        StudentEntity entity = studentRepository.getById(id);
        entity.setEmail(studentDto.getEmail());
        entity.setPhone(studentDto.getPhone());
        entity.setFirstName(studentDto.getFirstName());
        entity.setLastName(studentDto.getLastName());
        studentRepository.save(entity);
    }

    @Override
    public void deleteStudent(String number) {
        studentRepository.deleteByPhone(number);
    }

    @Override
    public StudentDto getStudent(String number) {
       StudentEntity entity =  studentRepository.findByPhone(number);
       return  studentMapper.toDto(entity);
    }

    @Override
    public List<StudentDto> getAllStudent() {
       return studentMapper.toDtoList(studentRepository.findAll());
    }
}
