package com.example.ingresspaymentproject.mapper;

import com.example.ingresspaymentproject.dto.StudentDto;
import com.example.ingresspaymentproject.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class StudentMapper {

public StudentEntity fromDto(StudentDto studentDto){
    StudentEntity entity = StudentEntity.builder()
            .email(studentDto.getEmail())
            .firstName(studentDto.getFirstName())
            .lastName(studentDto.getLastName())
            .phone(studentDto.getPhone())
            .build();
    return entity;
}

    public List<StudentEntity> fromDtoList(List<StudentDto> studentDtos){
        StudentMapper mapper = new StudentMapper();
       return studentDtos.stream().map(n->mapper.fromDto(n)).collect(Collectors.toList());

    }
    public StudentDto toDto(StudentEntity studentEntity){
        StudentDto student = StudentDto.builder()
                .email(studentEntity.getEmail())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .phone(studentEntity.getPhone())
                .id(studentEntity.getId())
                .build();
        return student;
    }

    public List<StudentDto> toDtoList(List<StudentEntity> studentEntity){
        StudentMapper mapper = new StudentMapper();
        return studentEntity.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }

}
