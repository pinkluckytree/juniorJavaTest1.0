package com.example.juniorjavatest;

import com.example.juniorjavatest.domain.CourseSelect;
import com.example.juniorjavatest.service.CourseSelectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = JuniorJavaTestApplication.class)
@RunWith(SpringRunner.class)
public class CourseSelectTest {
    @Autowired
    CourseSelectService service;

    @Test
    public void addCSTest(){
        CourseSelect cs=new CourseSelect();
        cs.setCourseId(1001L);
        cs.setStudentId(20181001L);
        service.addCS(cs);
    }
}
