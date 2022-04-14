package com.example.juniorjavatest.service;

import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.domain.vo.StudentVo;

import java.util.List;

public interface StudentService {

    //增
    void addStudent(Student student);

    //根据一个对象来删除
    void deleteStudent(Student student);

    //根据主键id删除
    void deleteStudentById(Long id);

    //根据名字模糊查询
    List<Student> queryStudentsByName(String name);

    //根据年级精确查询
    List<Student> queryStudentsByGrade(Integer grade);

    //根据性别精确查询
    List<Student> queryStudentsBySex(Integer Sex);

    //关联查询一个
    StudentVo queryStudentVoById(Long id);
    //关联查询全部
    List<StudentVo> queryStudentVo();


    void updateStudent(Student student);

    //学生和课程的关联保存
    void saveStudentVo(StudentVo studentVo);



}
