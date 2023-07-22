package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.CoursesDto;
import com.example.ingresspaymentproject.entity.CoursesEntity;
import com.example.ingresspaymentproject.exception.MethodArgumentNotValidException;
import com.example.ingresspaymentproject.mapper.CoursesMapper;
import com.example.ingresspaymentproject.repository.CoursesRepository;
import com.example.ingresspaymentproject.service.impl.CoursesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
//@DisplayNameGeneration((DisplayNameGenerator.ReplaceUnderscores.class))
public class CoursesServiceTest {
    @InjectMocks
    private CoursesServiceImpl coursesService;

    @Mock
    private CoursesRepository coursesRepository;

    @Mock
    private CoursesMapper mapper;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCourse_Success() throws MethodArgumentNotValidException {
        CoursesDto coursesDto=new CoursesDto();
        coursesDto.setCourseName("Swift");
        when(coursesRepository.findCoursesEntitiesByCourseNameContainsIgnoreCase(coursesDto.getCourseName()))
                .thenReturn(null);
        CoursesEntity coursesEntity=new CoursesEntity();
        when(mapper.fromDto(coursesDto)).thenReturn(coursesEntity);
        coursesService.saveCourse(coursesDto);
        verify(coursesRepository,times(1)).save(coursesEntity);
    }
}
