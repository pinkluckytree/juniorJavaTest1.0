package com.example.juniorjavatest.service;

import com.example.juniorjavatest.domain.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);

    void deleteCourse(Course course);

    void deleteCourseById(Long id);

    List<Course> queryCoursesByName(String name);

    void updateCourse(Course course);

    Course queryCourseById(Long id);
}
