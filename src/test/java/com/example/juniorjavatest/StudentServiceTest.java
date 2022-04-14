package com.example.juniorjavatest;

import com.example.juniorjavatest.domain.Course;
import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.domain.vo.StudentVo;
import com.example.juniorjavatest.service.CourseService;
import com.example.juniorjavatest.service.StudentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * 测试studentservice中的业务方法，包括增删改 以及三个有条件的查询*/
@SpringBootTest(classes = JuniorJavaTestApplication.class)
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    private StudentService service;
    @Autowired
    private CourseService courseService;
    //添加学生
    @Test
    public void addStudentTest(){
        Student student=new Student();
        student.setId(20180005L);
        student.setStudName("wangwu");
        student.setGrade(1);
        student.setSex(0);
        service.addStudent(student);
    }

    @Test
    public void deleteStudentTest(){
        service.deleteStudentById(20180013L);
    }
    //测试通过名字模糊查询
    @Test
    public void queryStudentsByNameTest(){
        service.queryStudentsByName("ang");
    }

    //测试通过年级查询
    @Test
    public void queryStudentsByGradeTest(){
        service.queryStudentsByGrade(1);
    }

    //测试通过性别查询
    @Test
    public void queryStudentsBySexTest(){
        service.queryStudentsBySex(0);
    }

    //关联查询测试
    @Test
    public void queryStudentVoByIdTest(){
        service.queryStudentVoById(20180001L);
    }

    //关联保存测试
    @Test
    public void saveStudentVoTest(){
        StudentVo studentVo=new StudentVo();
        studentVo.setId(20180020L);
        studentVo.setStudName("zhangshisi");
        studentVo.setSex(0);
        studentVo.setGrade(4);
        List<Course>courseList=new LinkedList<>();
        courseList.add(courseService.queryCourseById(1003L));
        courseList.add(courseService.queryCourseById(1006L));
        courseList.add(courseService.queryCourseById(1010L));
        studentVo.setCourseList(courseList);
        service.saveStudentVo(studentVo);
    }

    //测试更新学生
    @Test
    public void updateStudentTest(){
        Student student=new Student();
        student.setId(20180001L);
        student.setStudName("liuyi");
        student.setGrade(4);
        student.setSex(0);
        service.updateStudent(student);
    }



}
