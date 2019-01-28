<%--
  Created by IntelliJ IDEA.
  User: xinqin
  Date: 2019/1/14
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery.min.js"></script>
    <script type="text/javascript">
        //登录失败弹出框
        $(document).ready(function(){
            //使用EL获取登录标记
            if(${j}=="1"){
                window.alert("用户名或者密码错误，请重新输入");
            }
        });
    </script>
</head>
<body>

<div class="container">
    <div class="login">
        <div class="message">酒店预订管理系统登录</div>
        <div id="darkbannerwrap"></div>
        <form action="LoginServlet" method="post" class="" >
            <input name="username" placeholder="用户名"  type="text" class="form-control" >

            <input name="password"  placeholder="密码"  type="password" class="form-control">

            <input value="登录" type="submit" class="form-control sub">
        </form>
    </div>
</div>

</body>
</html>
