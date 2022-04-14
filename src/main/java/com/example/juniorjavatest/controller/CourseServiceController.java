package com.example.juniorjavatest.controller;


import com.example.juniorjavatest.domain.Course;
import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.service.CourseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseService")
public class CourseServiceController {
    @Autowired
    CourseService service;

    /**
     * 添加课程*/
    @PostMapping("/addCourse")
    public void addCourse(@RequestBody Course course){
        service.addCourse(course);
    }


    /**
     * 删除课程*/
    @PostMapping("/deleteCourse")
    public void deleteCourse(Long id){
        service.deleteCourseById(id);
    }

    /**
     * 修改课程*/
    @PostMapping("/updateCourse")
    public void updateCourse(@RequestBody Course course){
        service.updateCourse(course);
    }

    /**
     * 查询课程*/
    @GetMapping("/queryCourses")
    public List<Course> queryCourse(String name,Integer pageNum,Integer pageSize){
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Course>list=service.queryCoursesByName(name);
        return list;
    }



}
