package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.entity.CoursesEntity;
import com.example.ingresspaymentproject.exception.ResourceNotFoundException;
import com.example.ingresspaymentproject.mapper.CoursesMapper;
import com.example.ingresspaymentproject.repository.CoursesRepository;
import com.example.ingresspaymentproject.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {
    private final CoursesMapper  mapper;
    private final CoursesRepository repository;
    @Override
    public void saveCourse(CoursesDto courseDto) {
        CoursesEntity entity = mapper.fromDto(courseDto);
        repository.save(entity);
    }

    @Override
    public void updateCourse(CoursesDto courseDto) {
        CoursesEntity entity = mapper.fromDto(courseDto);
        repository.save(entity);
    }

    @Override
    public void deleteCourse(String name) {
        if(repository.findByCourseName(name).getCourseName().isEmpty()){
            throw new ResourceNotFoundException("Data not found");
        }
        repository.deleteByCourseName(name);
    }

    @Override
    public CoursesDto getCourse(String name) throws ResourceNotFoundException {
        if(repository.findByCourseName(name).getCourseName().isEmpty()){
            throw new ResourceNotFoundException("Data not found");
        }
        CoursesEntity coursesEntity = repository.findByCourseName(name);
        return mapper.toDto(coursesEntity);
    }

    @Override
    public List<CoursesDto> getAllCourses() {
        List<CoursesEntity> coursesEntity = repository.findAll();
        return mapper.toDtoList(coursesEntity);
    }
}
