<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/24
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="upServlet" method="post">
        <input type="hidden" value="<%=request.getParameter("uid")%>" name="uid"><br/>
        用户名<input type="text" name="upname"><br/>
        邮箱<input type="text" name="upmail"><br/>
        电话<input type="text"name="upphone"><br/>
        职务<select name="uptype">
        <option>总裁</option>
        <option>总经理</option>
        <option>销售经理</option>
        <option>业务经理</option>
        <option>后勤经理</option>
        <option>保洁</option>
        <option>保安</option>
    </select></br>
        <%--职务<input type="text" name="uptype"><br/>--%>
        <input type="submit" value="修改">

    </form>
</body>
</html>
