package com.test.servlet;

import com.test.service.impl.roleServiceImpl;
import com.test.service.impl.userServiceImpl;
import com.test.service.impl.user_roleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/upServlet")
public class upServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String upname = request.getParameter("upname");
        String upmail = request.getParameter("upmail");
        String upphone = request.getParameter("upphone");
        String uptype = request.getParameter("uptype");
        String uid = request.getParameter("uid");
        roleServiceImpl roleService = new roleServiceImpl();
        int type = roleService.getType(uptype);
        userServiceImpl userService = new userServiceImpl();
        int i = userService.upUser(Integer.parseInt(uid), upname, upmail, upphone, type);
        user_roleServiceImpl user_roleService = new user_roleServiceImpl();
        user_roleService.upUR(Integer.parseInt(uid),type);

        PrintWriter out = response.getWriter();
        if(i>0){
            out.write("<script>alert('修改成功');location.href='manage.jsp';</script>");
        }else {
            out.write("<script>alert('修改失败');location.href='manage.jsp';</script>");
        }
//        System.out.println(uid);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
