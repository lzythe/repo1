<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/18
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script>
    $(function () {
        $("#zhuce").click(function () {

            var name = $("#name").val();
            var pwd = $("#pwd").val();
            var age = $("#age").val();
            var lie = $("#lie").val();
            if(name == ""){
                alert("用户名不能为空");
                return;
            }
            $.ajax({
                "url":"studentRegisteServlet",
                "type":"post",
                "data":{"name":name,"pwd":pwd,"age":age,"lie":lie},
                "dataType":"json",
                "success":function (rel) {
                    if(rel != null){
                        alert("用户名已存在")
                    }else{
                        alert("注册成功")
                        location.href="login.jsp";
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
    <form action="/studentRegisteServlet" method="post">
        姓名<input type="text" name="name" id="name"><br/>
        密码<input type="password" name="pwd" id="pwd"><br/>
        年龄<input type="text" name="age" id="age"><br/>
        <select name="lie" id="lie">
            <%--<option>高软一班</option>--%>
            <%--<option>高软二班</option>--%>
            <%--<option>高软三班</option>--%>
            <%--<option>高软四班</option>--%>
            <%--<option>高软五班</option>--%>
            <%--<option>3G4G</option>--%>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
        </select><br/>
        <input type="button" value="立刻注册" id="zhuce">
        <%--<input type="submit" value="立刻注册">--%>
    </form>


</body>
</html>
