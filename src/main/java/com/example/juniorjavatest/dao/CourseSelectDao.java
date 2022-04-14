package com.example.juniorjavatest.dao;

import com.example.juniorjavatest.domain.Course;
import com.example.juniorjavatest.domain.CourseSelect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Mapper
public interface CourseSelectDao {
    /**
     * 添加操作*/
    void insertCS(CourseSelect courseSelect);

    /**
     * 更新操作*/
    void updateCS(CourseSelect courseSelect);

    /**
     * 删除操作*/
    void deleteCS(CourseSelect courseSelect);

    void deleteCSById(Integer id);

    void deleteCSByStudentId(@Param(value="stuId")Long id);

    void deleteCSByCourseId(@Param(value="courseId")Long id);

    /**
     * 查询操作*/

    CourseSelect selectCSById(Integer id);

    List<CourseSelect> selectCSByCourseId(Long id);

    CourseSelect selectCSByTwoId(@Param("stu") Long stuId,@Param("course") Long courseId);




}
