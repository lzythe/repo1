package com.test.servlet;

import com.test.entity.student;
import com.test.service.impl.studentServiceImpl;
import com.test.until.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pageServlet")
public class pageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentPage");
        if(currentPage == null  || currentPage == ""){
            currentPage = "1";
        }
        studentServiceImpl studentservice = new studentServiceImpl();
        Page page = new Page();
        page.setCurrentPage(Integer.parseInt(currentPage));
        page.setPagesize(3);
        page.setTotaCount(studentservice.getpageCount());
        page.setTotalPage((int)Math.ceil(studentservice.getpageCount()*1.0 / page.getPagesize()));
        List<student> studentPage = studentservice.getStudentPage(page.getCurrentPage(), page.getPagesize());
        page.setPageList(studentPage);
        System.out.println(studentPage);
        request.setAttribute("pages",page);
        request.getRequestDispatcher("index.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
