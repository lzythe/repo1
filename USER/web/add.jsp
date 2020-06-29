<%@ page import="com.test.service.impl.roleServiceImpl" %>
<%@ page import="com.test.entity.role" %>
<%@ page import="java.util.List" %>
<%@ page import="com.test.service.impl.userServiceImpl" %>
<%@ page import="com.test.entity.user" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/24
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script>

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="AddServlet" method="post">
    <input type="hidden"  value="<%=request.getParameter("uid")%>" name="uid">
    用户名<input type="text" name="username"></br>
    密码<input type="password"name="password"></br>
    确认密码<input type="password"name="zpassword"></br>
    邮箱<input type="text"name="mail"></br>
    电话<input type="text"name="phone"></br>
    职务<select name="type">
        <option>总裁</option>
        <option>总经理</option>
        <option>销售经理</option>
        <option>业务经理</option>
        <option>后勤经理</option>
        <option>保洁</option>
        <option>保安</option>
</select></br>
    <%--<input type="text"name="type"></br>--%>


    <input type="submit" value="添加">


</form>
<%
    userServiceImpl userService = new userServiceImpl();
    List<user> userList = userService.Alluser();
    for (int a = 0; a < userList.size(); a++) {
        userList.get(a).getUid();
    }
%>

</body>
</html>
