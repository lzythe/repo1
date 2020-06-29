package com.test.servlet;

import com.alibaba.fastjson.JSON;
import com.test.entity.student;
import com.test.service.impl.studentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/studentRegisteServlet")
public class studentRegisteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String age = request.getParameter("age");
        String zclass = request.getParameter("lie");
        PrintWriter out = response.getWriter();

        studentServiceImpl studentservice = new studentServiceImpl();
        student student1 = studentservice.judge(name);

        if(student1 == null || student1.equals(null)){
            student student = new student();
            student.setS_name(name);
            student.setS_pwd(pwd);
            student.setS_age(Integer.parseInt(age));
            student.setS_class(Integer.parseInt(zclass));
            studentservice.addStudents(student);
        }
       String json = JSON.toJSONString(student1);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
