<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/18
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script>
    $(function () {
        $("#registe").click(function () {
            window.location.href="registe.jsp";
        })

        $("#deng").click(function () {
            var name = $("#name").val();
            var password = $("#password").val();
            $.ajax({
                "url":"studentLoginServlet",
                "type":"post",
                "data":{"name":name,"password":password},
                "dataType":"json",
                "success":function (ret) {
                    if(ret == null){
                        alert("用户名密码错误")
                    }else {
                        location.href="index.jsp";
                    }
                }
            })
        })
    })
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form>
        姓名<input type="test" name="name" id="name"><br>
        密码<input type="password" name="password" id="password"><br>
        <input type="button" value="登录" id="deng">
        <input type="button" value="注册" id="registe">

        <br>
    </form>
</body>
</html>
