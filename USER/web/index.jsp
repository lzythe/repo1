<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/24
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script>
    $(function () {
        $("#deng").click(function () {
            var phone = $("#phone").val();
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
</script>--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="userServlet" method="post">
    手机<input type="text" name="phone" id="phone"></br>
    密码<input type="password" name="password" id="password"></br>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
