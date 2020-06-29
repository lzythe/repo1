package com.test.service.impl;

import com.test.dao.impl.studentDaoImpl;
import com.test.dao.studentDao;
import com.test.entity.student;
import com.test.service.studentService;

import java.util.List;

public class studentServiceImpl implements studentService {
    studentDaoImpl studentdao = new studentDaoImpl();
    public student AllStudent(String name,String password){

        student student = studentdao.findAllStudent(name,password);
        return student;
    }

    public int addStudents(student student){

            return studentdao.addStudent(student);
    }

    public student	judge(String name){
        student student = studentdao.judge(name);
        return student;
    }



    @Override
    public int getpageCount() {
        return studentdao.getpageCount();
    }

    @Override
    public List<student> getStudentPage(int currentPage, int pageCount) {
        return studentdao.getStudentPage(currentPage,pageCount);
    }



}
