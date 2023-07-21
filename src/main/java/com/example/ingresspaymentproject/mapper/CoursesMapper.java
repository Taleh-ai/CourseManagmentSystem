package com.example.ingresspaymentproject.mapper;

import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.dto.StudentDto;
import com.example.ingresspaymentproject.entity.CoursesEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class CoursesMapper {
  public CoursesEntity fromDto(CoursesDto coursesDto){
    CoursesEntity entity = CoursesEntity.builder()
            .courseName(coursesDto.getCourseName())
            .build();
    return entity;
}

    public List<CoursesEntity> fromDtoList(List<CoursesDto> coursesDtoList){
        CoursesMapper mapper = new CoursesMapper();
       return coursesDtoList.stream().map(n->mapper.fromDto(n)).collect(Collectors.toList());

    }
    public CoursesDto toDto(CoursesEntity courseEntity){
        CoursesDto course = CoursesDto.builder()
                .courseName(courseEntity.getCourseName())
                .id(courseEntity.getId())
                .build();
        return course;
    }

    public List<CoursesDto> toDtoList(List<CoursesEntity> coursesEntity){
        CoursesMapper mapper = new CoursesMapper();
        return coursesEntity.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }
}
