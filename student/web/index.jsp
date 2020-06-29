<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/18
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<c:if test="${pages != null}">
    <table border="1" align="center">
        <c:forEach items="${pages.pageList}" var="stu">
            <tr>
                <td> 姓名：<span>${stu.s_name}</span></td>
                <td> 密码：<span>${stu.s_pwd}</span></td>
                <td> 年龄：<span>${stu.s_age}</span></td>
                <td> 班级：<span>${stu.s_class}</span></td>
            </tr>

        </c:forEach>
    </table>
</c:if>
<c:if test="${pages == null}">
    <jsp:forward page="pageServlet"></jsp:forward>
</c:if>


<p align="center">

    <c:if test="${pages.currentPage != 1}">
    <a href="pageServlet?currentPage=1">首页</a>
    <a href="pageServlet?currentPage=${pages.currentPage - 1}">上一页</a>
    </c:if>
    <c:if test="${pages.currentPage != pages.totalPage}">
    <a href="pageServlet?currentPage=${pages.currentPage + 1}">下一页</a>
    <a href="pageServlet?currentPage=${pages.totalPage}">尾页</a>
    </c:if>
    <span>第${pages.currentPage}页/共${pages.totalPage}页</span>
    <span>共${pages.totaCount}记录</span>

</p>

</body>
</html>
