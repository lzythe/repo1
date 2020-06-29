package com.test.servlet;

import com.ndktools.javamd5.Mademd5;
import com.test.dao.impl.roleDaoImpl;
import com.test.dao.roleDao;
import com.test.entity.user;
import com.test.service.impl.roleServiceImpl;
import com.test.service.impl.userServiceImpl;
import com.test.service.impl.user_roleServiceImpl;
import com.test.service.user_roleService;
import sun.security.provider.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

//        String uid = request.getParameter("uid");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String zpassword = request.getParameter("zpassword");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        userServiceImpl userService = new userServiceImpl();
        roleServiceImpl roleService = new roleServiceImpl();
        int type1 = roleService.getType(type);
        Mademd5 mademd5 = new Mademd5();
        String pwd = mademd5.toMd5(password);
        user user = new user();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setMail(mail);
        user.setPhone(phone);
        user.setType(type1);

        userService.adduser(user);
        //添加user_role表
        //type1  rid
//        userServiceImpl userService = new userServiceImpl();
        List<user> userList = userService.Alluser();
       int uid = 0;
        for ( int a = 0; a < userList.size(); a++) {
            uid = userList.get(a).getUid();
        }
        System.out.println(uid);
        user_roleServiceImpl user_roleService = new user_roleServiceImpl();
        user_roleService.addUR(uid,type1);

        request.getRequestDispatcher("manage.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
