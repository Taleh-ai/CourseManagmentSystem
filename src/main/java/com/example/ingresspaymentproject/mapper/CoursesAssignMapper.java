package com.example.ingresspaymentproject.mapper;

import com.example.ingresspaymentproject.dto.CoursesAssignDto;
import com.example.ingresspaymentproject.entity.CoursesAssignEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class CoursesAssignMapper {

    public CoursesAssignEntity fromDto(CoursesAssignDto coursesAssignDto){
        CoursesAssignEntity entity = CoursesAssignEntity.builder()
                .courseName(coursesAssignDto.getCourseName())
                .isActive(coursesAssignDto.isActive())
                .studentNumber(coursesAssignDto.getStudentNumber())
                .build();
        return entity;
    }

    public List<CoursesAssignEntity> fromDtoList(List<CoursesAssignDto> coursesAssignDtoList){
        CoursesAssignMapper mapper = new CoursesAssignMapper();
        return coursesAssignDtoList.stream().map(n->mapper.fromDto(n)).collect(Collectors.toList());

    }
    public CoursesAssignDto toDto(CoursesAssignEntity coursesAssignEntity){
        CoursesAssignDto coursesAssignDto = CoursesAssignDto.builder()
                .courseName(coursesAssignEntity.getCourseName())
                .isActive(coursesAssignEntity.isActive())
                .studentNumber(coursesAssignEntity.getStudentNumber())
                .id(coursesAssignEntity.getId())
                .build();
        return coursesAssignDto;
    }

    public List<CoursesAssignDto> toDtoList(List<CoursesAssignEntity> coursesAssignEntityList){
        CoursesAssignMapper mapper = new CoursesAssignMapper();
        return coursesAssignEntityList.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }
}
