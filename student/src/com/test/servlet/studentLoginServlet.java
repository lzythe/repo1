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

@WebServlet("/studentLoginServlet")
public class studentLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { ;
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        studentServiceImpl studentService = new studentServiceImpl();
        student student = studentService.AllStudent(name,pwd);
        String json = JSON.toJSONString(student);
        response.getWriter().write(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
