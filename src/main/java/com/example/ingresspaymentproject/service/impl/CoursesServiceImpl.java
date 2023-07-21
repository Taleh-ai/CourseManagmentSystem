package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.entity.CoursesEntity;
import com.example.ingresspaymentproject.exception.MethodArgumentNotValidException;
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
    public void saveCourse(CoursesDto courseDto) throws MethodArgumentNotValidException {
        CoursesEntity existingCourse = repository.findCoursesEntitiesByCourseNameContainsIgnoreCase(courseDto.getCourseName());

        if (existingCourse == null) {
            CoursesEntity entity = mapper.fromDto(courseDto);
            repository.save(entity);
        } else {
            throw new MethodArgumentNotValidException("Course already exists");
        }
        }


    @Override
    public void updateCourse(Long id,CoursesDto courseDto) throws MethodArgumentNotValidException {
        CoursesEntity existingCourse = repository.findCoursesEntitiesByCourseNameContainsIgnoreCase(courseDto.getCourseName());
        if (existingCourse != null) {
            throw new MethodArgumentNotValidException("Course already exists");
        }else{
            CoursesEntity entity = repository.getById(id) ;
            entity.setCourseName(courseDto.getCourseName());
            repository.save(entity);
        }

    }

    @Override
    public void deleteCourse(String name) {
        if(repository.findByCourseName(name).getCourseName().isEmpty()){
            throw new ResourceNotFoundException("Data not found");
        }
        repository.deleteByCourseName(name);
    }

    @Override
    public List<CoursesDto> getAllCourses() {
        List<CoursesEntity> coursesEntity = repository.findAll();
        return mapper.toDtoList(coursesEntity);
    }
}
