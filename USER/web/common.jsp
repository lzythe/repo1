<%@ page import="com.test.service.impl.userServiceImpl" %>
<%@ page import="com.test.entity.user" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/25
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>姓名</td>
        <td>邮箱</td>
        <td>电话</td>
        <td>职务</td>
        <td>操作</td>
    </tr>
    <%
        userServiceImpl userService = new userServiceImpl();
        List<user> userList = userService.Alluser();
        for (int i = 0; i < userList.size(); i++) {
    %>
    <tr>
        <td><%=userList.get(i).getUsername()%></td>
        <td><%=userList.get(i).getMail()%></td>
        <td><%=userList.get(i).getPhone()%></td>
    </tr>

    <%}%>
</table>
</body>
</html>
