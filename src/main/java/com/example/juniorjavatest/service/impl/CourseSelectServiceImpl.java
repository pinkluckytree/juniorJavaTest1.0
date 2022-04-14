package com.example.juniorjavatest.service.impl;

import com.example.juniorjavatest.dao.CourseDao;
import com.example.juniorjavatest.dao.CourseSelectDao;
import com.example.juniorjavatest.domain.CourseSelect;
import com.example.juniorjavatest.service.CourseSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectServiceImpl implements CourseSelectService {

    @Autowired
    private CourseSelectDao courseSelectDao;
    @Override
    public CourseSelect queryCS(Integer id) {
        CourseSelect cs=courseSelectDao.selectCSById(id);
        return cs;
    }

    @Override
    public List<CourseSelect> queryCSByCourseId(Long courseId) {
        List<CourseSelect>list=courseSelectDao.selectCSByCourseId(courseId);
        return list;
    }

    @Override
    public void addCS(CourseSelect courseSelect) {
        courseSelectDao.insertCS(courseSelect);
    }

    //更新操作，存在就更新，不存在就插入
    @Override
    public void updateCS(CourseSelect courseSelect) {
        if(courseSelectDao.selectCSByCourseId(courseSelect.getCourseId())!=null){
            courseSelectDao.updateCS(courseSelect);
        }
        courseSelectDao.insertCS(courseSelect);
    }

    @Override
    public void deleteCS(Integer id) {
        courseSelectDao.deleteCSById(id);
    }

    @Override
    public void deleteCSByStudentId(Long studentId) {
        courseSelectDao.deleteCSByStudentId(studentId);
    }

    @Override
    public void deleteCSByCourseId(Long courseId){
        courseSelectDao.deleteCSByCourseId(courseId);
    }
}
