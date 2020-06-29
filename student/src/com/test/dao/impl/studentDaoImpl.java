package com.test.dao.impl;

import com.test.dao.BaseDao;
import com.test.dao.studentDao;
import com.test.entity.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDaoImpl extends BaseDao implements studentDao {
    public student findAllStudent(String name,String password){
        String sql = "select * from student where s_name=? and s_pwd=?";
        ResultSet rs = executeQuery(sql,name,password);
        student student = null;
        try {
            if(rs.next()){
                student = new student();
                student.setS_id(rs.getInt("s_id"));
                student.setS_name(rs.getString("s_name"));
                student.setS_age(rs.getInt("s_age"));
                student.setS_class(rs.getInt("s_class"));
                student.setS_pwd(rs.getString("s_pwd"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    //添加用户
    public int addStudent(student student){
        String sql = "insert into student (s_name,s_age,s_class,s_pwd) values (?,?,?,?)";
        Object[] params ={student.getS_name(),student.getS_age(),student.getS_class(),student.getS_pwd()};
        int a = executeUpdate(sql,params);


        return a;

    }
    //判断用户是否存在
    public student judge(String name){
        String sql = "select * from student where s_name=?";
        ResultSet rs = executeQuery(sql,name);
        student student = null;
        try {
            if(rs.next()){
                student = new student();
                student.setS_id(rs.getInt("s_id"));
                student.setS_name(rs.getString("s_name"));
                student.setS_age(rs.getInt("s_age"));
                student.setS_class(rs.getInt("s_class"));
                student.setS_pwd(rs.getString("s_pwd"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }



    //分页
    @Override
    public int getpageCount() {

        String sql = "select count(*) from student";
        ResultSet rs = executeQuery(sql, null);
        int mun = 0;
        try {
            if(rs.next()){
                 mun = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mun;
    }

    @Override
    public List<student> getStudentPage  (int currentPage,int pageCount) {
        String sql = "select * from student limit ?,?";
        Object[] params = {(currentPage - 1)*pageCount,pageCount};
        ResultSet rs = executeQuery(sql, params);
        List<student> list = new ArrayList<>();
        try {
            while (rs.next()){
                student student = new student();
                student.setS_id(rs.getInt("s_id"));
                student.setS_name(rs.getString("s_name"));
                student.setS_age(rs.getInt("s_age"));
                student.setS_class(rs.getInt("s_class"));
                student.setS_pwd(rs.getString("s_pwd"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        studentDaoImpl studentDao = new studentDaoImpl();
//        studentDao.getpageCount();
        List<student> studentPage = studentDao.getStudentPage(1, 3);
        for (student student : studentPage) {
            System.out.println(student.getS_name());
        }


    }
}
