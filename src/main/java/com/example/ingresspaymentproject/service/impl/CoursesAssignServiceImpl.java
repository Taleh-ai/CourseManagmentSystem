package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.CoursesAssignDto;
import com.example.ingresspaymentproject.entity.CoursesAssignEntity;
import com.example.ingresspaymentproject.exception.ResourceNotFoundException;
import com.example.ingresspaymentproject.mapper.CoursesAssignMapper;
import com.example.ingresspaymentproject.repository.CoursesAssignRepository;
import com.example.ingresspaymentproject.repository.StudentRepository;
import com.example.ingresspaymentproject.service.CoursesAssignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesAssignServiceImpl implements CoursesAssignService {
    private final CoursesAssignRepository  coursesAssignRepository;
    private final StudentRepository studentRepository;
    private final CoursesAssignMapper coursesAssignMapper;
    @Override
    public void assignCourse(CoursesAssignDto coursesAssignDto) {
        if(studentRepository.findByPhone(coursesAssignDto.getStudentNumber()).getPhone().isEmpty()){
        throw new ResourceNotFoundException("Student not found");
        }
        CoursesAssignEntity entity = coursesAssignMapper.fromDto(coursesAssignDto);
        coursesAssignRepository.save(entity);
    }

    @Override
    public void updateCourse(Long id, CoursesAssignDto coursesAssignDto) {
        CoursesAssignEntity entity = coursesAssignRepository.getById(id) ;
        entity.setCourseName(coursesAssignDto.getCourseName());
        entity.setActive(coursesAssignDto.isActive());
        entity.setStudentNumber(coursesAssignDto.getStudentNumber());
        coursesAssignRepository.save(entity);
    }

    @Override
    public List<CoursesAssignDto> getAllCourses(String name) {
      return   coursesAssignMapper.toDtoList(coursesAssignRepository.getAllByCourseNameContainsIgnoreCase(name)) ;

    }

    @Override
    public List<CoursesAssignDto> getAllCourses() {
        return  coursesAssignMapper.toDtoList(coursesAssignRepository.findAll()) ;
    }
}
