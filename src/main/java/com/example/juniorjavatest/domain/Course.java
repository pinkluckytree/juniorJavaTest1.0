package com.example.juniorjavatest.domain;



public class Course {
    private Long id;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private Float credit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course实体:{" +
                "id=" + id +
                ", name='" + courseName + '\'' +
                ", credit=" + credit +
                '}';
    }
}
