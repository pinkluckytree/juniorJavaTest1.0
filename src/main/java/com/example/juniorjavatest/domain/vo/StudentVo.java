package com.example.juniorjavatest.domain.vo;

import com.example.juniorjavatest.domain.Course;

import java.util.List;

public class StudentVo {
    private Long id;
    private String studName;
    private Integer sex;//性别为1是男,性别为0是女
    private Integer grade;//
    private List<Course>courseList;//该学生的课程列表

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "id=" + id +
                ", studName='" + studName + '\'' +
                ", sex=" + sex +
                ", grade=" + grade +
                ", courseList=" + courseList +
                '}';
    }
}
