package com.example.juniorjavatest;

import com.example.juniorjavatest.domain.Course;
import com.example.juniorjavatest.service.CourseService;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = JuniorJavaTestApplication.class)
@RunWith(SpringRunner.class)
public class CourseServiceTest {
    @Autowired
    CourseService service;
    @Test
    public void addCourseTest(){
        Course course=new Course();
        course.setId(1010L);
        course.setCourseName("language");
        course.setCredit(4.0f);
        service.addCourse(course);
    }

    @Test
    public void deleteCourseByIdTest(){
        service.deleteCourseById(1007L);
    }

    @Test
    public void queryCourseByIdTest(){
        Course course=service.queryCourseById(1001L);
        System.out.println("course = " + course);
    }

    @Test
    public void updateCourse(){
        Course course=new Course();
        course.setId(1011L);
        course.setCourseName("language");
        course.setCredit(4.0f);
        service.updateCourse(course);
    }
}
