package com.example.juniorjavatest.controller;

import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.domain.vo.StudentVo;
import com.example.juniorjavatest.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生表*/
@RestController
@RequestMapping("/studentService")
public class StudentServiceController {

    @Autowired
    StudentService service;

    /**
     * 添加学生*/
    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }


    /**
     * 删除学生*/
    @PostMapping("/deleteStudent")
    public void deleteStudent(Long id){
        service.deleteStudentById(id);
    }

    /**
     * 通过学生名字模糊查询*/
    @GetMapping("/queryStudentsByName")
    public List<Student>queryStudentsByName(String name,Integer pageNum,Integer pageSize){
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = service.queryStudentsByName(name);
        return list;
    }

    /**
     * 通过年级精确查询*/
    @GetMapping("/queryStudentsByGrade")
    public List<Student> queryStudentsByGrade(Integer grade,Integer pageNum,Integer pageSize){
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = service.queryStudentsByGrade(grade);
        return list;
    }
    /**
     * 通过性别精确查找*/
    @GetMapping("/queryStudentsBySex")
    public List<Student> queryStudentsBySex(Integer sex,Integer pageNum,Integer pageSize){
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Student>list=service.queryStudentsBySex(sex);
        return list;
    }

    /**
     * 学生表与课程表关联查询*/
    @GetMapping("/queryStudentVoById")
    public StudentVo queryStudentVoById(Long id){
        StudentVo studentVo=service.queryStudentVoById(id);
        return  studentVo;
    }

    @GetMapping("/queryStudentVos")
    public List<StudentVo> queryStudentVos(){
        List<StudentVo>list=service.queryStudentVo();
        return  list;
    }

    /**
     * 修改学生信息*/
    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student){
        service.updateStudent(student);
    }

    /**
     * 关联保存学生课程信息*/
    @PostMapping("/saveStudentVo")
    public void saveStudentVo(@RequestBody StudentVo studentVo){
        service.saveStudentVo(studentVo);
    }




}
