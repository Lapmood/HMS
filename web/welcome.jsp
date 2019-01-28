<%--
  Created by IntelliJ IDEA.
  User: xinqin
  Date: 2019/1/22
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">

    <style>
        body{
            margin: 0px;
        }
    </style>
</head>
<body>

    <div class="msg"></div>
    <div>
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
            <li class="active">我的桌面</li>
        </ol>
    </div>
    <img src="${pageContext.request.contextPath}/static/images/welcome.png" width="100%" height="70%" style="margin-top: 30px">
</body>
</html>
