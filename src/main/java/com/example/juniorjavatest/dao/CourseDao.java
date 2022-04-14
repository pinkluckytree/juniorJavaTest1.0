package com.example.juniorjavatest.dao;

import com.example.juniorjavatest.domain.Course;
import com.example.juniorjavatest.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * course持久层接口*/
@Mapper
public interface CourseDao {



    /**
     * 添加操作*/
    void insertCourse(Course course);

    /**
     * 更新操作*/
    void updateCourse(Course course);

    /**
     * 删除操作*/
    void deleteCourse(Course course);

    void deleteCourseById(Long id);

    /**
     * 查询操作*/
    List<Course> selectCourseByName(@Param(value = "myCourseName") String name);

    Course selectCourseById(Long id);




}
