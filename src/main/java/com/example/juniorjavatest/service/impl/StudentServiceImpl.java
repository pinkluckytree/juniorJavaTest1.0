package com.example.juniorjavatest.service.impl;

import com.example.juniorjavatest.dao.CourseDao;
import com.example.juniorjavatest.dao.CourseSelectDao;
import com.example.juniorjavatest.dao.StudentDao;
import com.example.juniorjavatest.domain.Course;
import com.example.juniorjavatest.domain.CourseSelect;
import com.example.juniorjavatest.domain.Student;
import com.example.juniorjavatest.domain.vo.StudentVo;
import com.example.juniorjavatest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //依赖注入
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseSelectDao courseSelectDao;
    @Autowired
    CourseSelectServiceImpl service;

    //添加操作
    @Override
    public void addStudent(Student student) {
        Long id=student.getId();
        //当id不重复，其他各项格式正确时可以进行添加操作
        if(studentDao.selectStudentById(id)==null){
            if(checkGrade(student.getGrade()) && checkSex(student.getSex())  && checkName(student.getStudName()) ){
                studentDao.insertStudent(student);
            }
        }
        else {
            System.out.println("该学号已经存在，学号冲突");
        }
    }


    //删除操作，传参为student对象，删除学生需要先删除 有外键的哪张表，也就是先删除关联，才能在student表中进行删除
    @Override
    @Transactional
    public void deleteStudent(Student student) {
        if(studentDao.selectStudentById(student.getId())==null){
            System.out.println("该学生不存在");
        }
        else {
            service.deleteCSByStudentId(student.getId());
            studentDao.deleteStudent(student);
        }
    }

    //删除学生需要先删除 有外键的哪张表，也就是先删除关联，才能在student表中进行删除
    @Override
    @Transactional
    public void deleteStudentById(Long id) {
        if(studentDao.selectStudentById(id)==null){
            System.out.println("学号为"+id+"的学生不存在，无法删除");
            return;
        }
        service.deleteCSByStudentId(id);
        studentDao.deleteStudentById(id);
    }

    //单表 通过name模糊查询
    @Override
    public List<Student> queryStudentsByName(String name) {
        List<Student>list=studentDao.selectStudentsByName(name);
        show(list);
        return list;
    }

    //单表 通过年级精确查询
    @Override
    public List<Student> queryStudentsByGrade(Integer grade) {
        if(!checkGrade(grade)){
            return null;
        }
        List<Student> list = studentDao.selectStudentsByGrade(grade);
        show(list);
        return list;
    }

    //单表 通过性别精确查询
    @Override
    public List<Student> queryStudentsBySex(Integer sex) {
        if(!checkSex(sex)){
            return null;
        }
        List<Student>list=studentDao.selectStudentsBySex(sex);
        show(list);
        return list;
    }

    //更新
    @Override
    public void updateStudent(Student student) {
        //如果这个student对象的id在数据库不存在，那么就进行插入操作
        if(studentDao.selectStudentById(student.getId())==null){
            this.addStudent(student);
        }
        //存在就进行参数格式判断然后更新操作
        if(checkGrade(student.getGrade()) && checkSex(student.getSex())  && checkName(student.getStudName()) ){
            studentDao.updateStudent(student);
        }
    }

    //学生和课程的关联保存,需要进行三张表的修改操作
    @Override
    public void saveStudentVo(StudentVo studentVo) {
        //1.student表，如果id存在，表示不用添加,否则需要先添加
        Student student = new Student();
        student.setId(studentVo.getId());
        student.setSex(studentVo.getSex());
        student.setStudName(studentVo.getStudName());
        student.setGrade(studentVo.getGrade());
        Long stuId=studentVo.getId();
        if(studentDao.selectStudentById(stuId)!=null){
            System.out.println("该学生已经存在，更新学生信息");
            this.updateStudent(student);
        }
        else {
            System.out.println("该学生不存在，添加进学生表");
            this.addStudent(student);
        }
        //2.课程表与关系表
        List<Course>courseList= studentVo.getCourseList();
        if(courseList==null){
            return;
        }
        for(Course course:courseList){
            //先检查课程是否存在，若存在就更新，不存在就添加
            if(courseDao.selectCourseById(course.getId())!=null){
                courseDao.updateCourse(course);
            }
            else{
                courseDao.insertCourse(course);
            }
            //添加进入选课表
            //判断 student_id,course_id 的组合是否存在，若存在就不能重复添加
            CourseSelect cs=new CourseSelect();
            cs.setStudentId(studentVo.getId());
            cs.setCourseId(course.getId());
            //通过这两个id进行查找如果没有就说明可以插入
            if(courseSelectDao.selectCSByTwoId(studentVo.getId(),course.getId())==null) {
                service.updateCS(cs);
            }
            else {
                System.out.println("此次插入的数据："+studentVo.getId()+"--"+course.getId()+"已经存在");
            }
        }
    }

    //学生表与课程表关联查询
    @Override
    public StudentVo queryStudentVoById(Long id) {
        StudentVo studentVo=studentDao.selectStudentVoById(id);
        System.out.println("studentVo = " + studentVo);
        return studentVo;
    }

    @Override
    public List<StudentVo> queryStudentVo() {
        List<StudentVo>list=studentDao.selectStudentVos();
        return list;
    }


    public void show(List<Student>list){
        System.out.println("查询结果list为：");
        for (Student obj:list){
            System.out.println(obj);
        }
    }

    //检查sex格式
    public boolean checkSex(Integer sex){
        if(sex==null){
            System.out.println("sex为null");
            return false;
        }
        if(sex==0||sex==1){
            return true;
        }
        else {
            System.out.println("sex格式错误，应为0或1");
            return false;
        }
    }
    //检查grade格式
    public  boolean checkGrade(Integer grade){
        if(grade==null){
            System.out.println("grade为null");
            return false;
        }
        if(grade<=0||grade>4){
            System.out.println("grade格式错误，应为1~4的整数表示大一至大四");
            return false;
        }
        return true;
    }
    //检查name
    public boolean checkName(String name){
        if(name==null){
            System.out.println("name为null");
            return false;
        }
        return true;

    }
}
