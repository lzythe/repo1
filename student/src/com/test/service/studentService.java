package com.test.service;

import com.test.entity.student;

import java.util.List;

public interface studentService {
    public student AllStudent(String name,String password);


    //添加数据
    public int addStudents(student student);

    public student judge(String name);




    public int getpageCount();//获取所有数据的数目

    public List<student> getStudentPage  (int currentPage, int pageCount);//获取当前的数据
}
