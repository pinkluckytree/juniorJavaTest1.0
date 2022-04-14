package com.example.juniorjavatest.domain;

public class Student {
    private Long id;
    private String studName;
    private Integer sex;//性别为1是男,性别为0是女
    private Integer grade;//

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

    @Override
    public String toString() {
        return "Student实体:{" +
                "id=" + id +
                ", name='" + studName + '\'' +
                ", sex=" + sex +
                ", grade=" + grade +
                '}';
    }
}
