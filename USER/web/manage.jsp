<%@ page import="com.test.service.impl.userServiceImpl" %>
<%@ page import="com.test.entity.user" %>
<%@ page import="java.util.List" %>
<%@ page import="com.test.service.impl.roleServiceImpl" %>
<%@ page import="com.test.entity.role" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/24
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="add.jsp">添加员工</a></br>
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
        roleServiceImpl roleService = new roleServiceImpl();
        List<role> roles = roleService.AllPost();
        String s = null;
        for (int i = 0; i < userList.size(); i++) {
            for (int a = 0; a < roles.size(); a++) {
                if(userList.get(i).getType() == roles.get(a).getRid()){
                   s = roles.get(a).getRolename();
                    break;
                }
            }
    %>
    <tr>
        <td><%=userList.get(i).getUsername()%></td>
        <td><%=userList.get(i).getMail()%></td>
        <td><%=userList.get(i).getPhone()%></td>
        <td><%=s%></td>
        <%--<td><a href="deleteServlet?uid=<%=userList.get(i).getUid()%>">修改</a>--%>
        <td><a href="up.jsp?uid=<%=userList.get(i).getUid()%>">修改</a>
            <a href="deleteServlet?uid=<%=userList.get(i).getUid()%>">删除</a>
        </td>
    </tr>
    <%}%>

</table>
</body>
</html>
