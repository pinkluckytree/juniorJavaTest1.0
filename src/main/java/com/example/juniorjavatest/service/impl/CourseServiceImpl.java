package com.example.juniorjavatest.service.impl;

import com.example.juniorjavatest.dao.CourseDao;
import com.example.juniorjavatest.domain.Course;
import com.example.juniorjavatest.domain.CourseSelect;
import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.service.CourseSelectService;
import com.example.juniorjavatest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseSelectService service;
    @Override
    public void addCourse(Course course) {
        if(courseDao.selectCourseById(course.getId())!=null){
            System.out.println("该课程在数据库中已经存在已经");
        }
        courseDao.insertCourse(course);
    }

    @Transactional
    @Override
    public void deleteCourse(Course course) {
        if(courseDao.selectCourseById(course.getId())==null){
            System.out.println("该课程不存在，无法删除");
        }
        //根据这个courseId去查找关联表中是否有关联，若有就不删除
        List<CourseSelect>list=service.queryCSByCourseId(course.getId());
        System.out.println("list = " + list);
        if(list.size()>0){
            System.out.println("该课程还有人在修习，不可删除");
        }
        else {
            courseDao.deleteCourseById(course.getId());
            System.out.println("删除完成");
        }
    }

    @Transactional
    @Override
    public void deleteCourseById(Long id) {
        if(id==null){
            return;
        }
        if(courseDao.selectCourseById(id)==null){
            System.out.println("课程号为"+id+"的课程不存在无法删除");
        }
        //根据这个courseId去查找关联表中是否有关联，若有就不删除
        List<CourseSelect>list=service.queryCSByCourseId(id);
        System.out.println("list = " + list);
        if(list.size()>0){
            System.out.println("该课程还有人在修习，不可删除");
        }
        else {
            courseDao.deleteCourseById(id);
            System.out.println("删除完成");
        }
    }


    @Override
    public List<Course> queryCoursesByName(String name) {
        List<Course>list=courseDao.selectCourseByName(name);
        show(list);
        return list;
    }

    @Override
    public void updateCourse(Course course) {
        //不存在就插入
        if(courseDao.selectCourseById(course.getId())==null){
            this.addCourse(course);
            return;
        }
        //存在就更新
        courseDao.updateCourse(course);
    }

    @Override
    public Course queryCourseById(Long id) {
        return courseDao.selectCourseById(id);
    }

    public void show(List<Course>list){
        System.out.println("查询结果list为：");
        for (Course obj:list){
            System.out.println(obj);
        }
    }
}
