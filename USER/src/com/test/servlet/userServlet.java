package com.test.servlet;

import com.ndktools.javamd5.Mademd5;
import com.test.entity.user;
import com.test.service.impl.userServiceImpl;
import sun.security.provider.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        Mademd5 mademd5 = new Mademd5();
        String pwd = mademd5.toMd5(password);

        userServiceImpl userService = new userServiceImpl();
       /* user us = userService.findAlluser(phone, password);
        user md5User = userService.findAlluser(phone, pwd);


        if((md5User.getType() == 1 || md5User.getType() == 2) || (us.getType() == 1 || us.getType() == 2)){
            request.getRequestDispatcher("manage.jsp").forward(request,response);
        }else if(md5User.getType()>2 || us.getType()>2){
            request.getRequestDispatcher("common.jsp").forward(request,response);
        }else{
            out.print("<script>alert('电话号码不存在!');window.location.href='index.jsp'</script>");
        }*/


        user alluser = userService.findAlluser(phone, pwd);

       if(alluser == null){
            out.print("<script>alert('电话号码不存在!');window.location.href='index.jsp'</script>");
        }else if(alluser.getType() == 1 || alluser.getType() == 2){
            request.getRequestDispatcher("manage.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("common.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
