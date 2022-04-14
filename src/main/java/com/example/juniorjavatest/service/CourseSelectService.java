package com.example.juniorjavatest.service;

import com.example.juniorjavatest.domain.CourseSelect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseSelectService {
    CourseSelect queryCS(Integer id);

    List<CourseSelect> queryCSByCourseId(Long courseId);

    void addCS(CourseSelect courseSelect);

    void updateCS(CourseSelect courseSelect);

    void deleteCS(Integer id);

    void deleteCSByStudentId(@Param(value = "stuId") Long StudentId);

    void deleteCSByCourseId(Long CourseId);

}
