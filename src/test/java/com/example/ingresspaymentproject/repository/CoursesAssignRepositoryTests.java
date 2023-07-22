package com.example.ingresspaymentproject.repository;

import com.example.ingresspaymentproject.entity.CoursesAssignEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CoursesAssignRepositoryTests {
    @Autowired
    private CoursesAssignRepository coursesAssignRepository;

    @BeforeEach
    public void setUp() {
        CoursesAssignEntity course = new CoursesAssignEntity();
        course.setStudentNumber("+9945555555555");
        course.setActive(true);
        course.setCourseName("Java");
        coursesAssignRepository.save(course);
    }

    @AfterEach
    public void tearDown(){
        coursesAssignRepository.deleteAll();
    }

    //getAllByCourseNameContainsIgnoreCase
    @Test
    public void testGetAllByCourseNameContainsIgnoreCase(){
        List<CoursesAssignEntity> coursesAssignEntityList = coursesAssignRepository.getAllByCourseNameContainsIgnoreCase("Java");
        assertEquals(1,coursesAssignEntityList.size());
        assertEquals("Java",coursesAssignEntityList.get(0).getCourseName());
    }

    @Test
    public void testGetAllByCourseNameContainsIgnoreCase_NoResult(){
        List<CoursesAssignEntity> coursesAssignEntityList = coursesAssignRepository.getAllByCourseNameContainsIgnoreCase("C#");
        assertEquals(0,coursesAssignEntityList.size());
    }
}
