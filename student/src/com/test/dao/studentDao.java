package com.test.dao;

import com.test.entity.student;

import java.util.List;

public interface studentDao {
    public student findAllStudent(String  name,String password);

    //添加学生
    public int addStudent(student student);


    public student judge(String name);


    //分页
    public int getpageCount();//获取所有数据的数目

    public List<student> getStudentPage  (int currentPage,int pageCount);//获取当前的数据

}
