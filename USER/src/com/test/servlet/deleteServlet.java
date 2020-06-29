package com.test.servlet;

import com.test.service.impl.userServiceImpl;
import com.test.service.impl.user_roleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");

        userServiceImpl userService = new userServiceImpl();
        int i = userService.delectUser(Integer.parseInt(uid));
        user_roleServiceImpl user_roleService = new user_roleServiceImpl();
        user_roleService.dtUR(Integer.parseInt(uid));
        PrintWriter out = response.getWriter();
        if(i>0){
            out.write("<script>alert('删除成功');location.href='manage.jsp'</script>");
        }else {
            out.write("<script>alert('删除失败');location.href='manage.jsp'</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
