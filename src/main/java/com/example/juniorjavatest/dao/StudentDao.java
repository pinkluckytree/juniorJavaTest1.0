package com.example.juniorjavatest.dao;

import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.domain.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生查询接口*/

@Mapper
public interface StudentDao {

    /**
     * 查询操作*/
    //根据姓名模糊查询
    List<Student> selectStudentsByName(@Param(value = "stuName")String name);

    //根据性别精确查询
    List<Student> selectStudentsBySex(@Param(value = "stuSex")Integer sex);

    //根据年级精确查询
    List<Student> selectStudentsByGrade(@Param(value = "stuGrade")Integer grade);

    Student selectStudentById(@Param(value = "stuId")Long id);

    //关联查询,同时查询学生与课程信息
    StudentVo selectStudentVoById(Long id);

    List<StudentVo> selectStudentVos();

    /**
     * 添加操作*/
    void insertStudent(Student student);

    /**
     * 更新操作*/
    void updateStudent(Student student);


    /**
     * 删除操作*/
    void deleteStudent(Student student);

    void deleteStudentById(Long id);




}
