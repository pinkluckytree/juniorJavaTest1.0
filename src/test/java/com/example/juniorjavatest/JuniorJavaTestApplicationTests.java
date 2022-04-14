package com.example.juniorjavatest;

import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.service.StudentService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JuniorJavaTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentService service;
    @Test
    public void addStudentTest(){
        Student student=new Student();
        student.setId(20180001L);
        student.setStudName("zhangsan");
        student.setGrade(1);
        student.setSex(1);
        service.addStudent(student);
    }

}
