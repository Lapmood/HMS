<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xinqin
  Date: 2019/1/23
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>

    <style>
        .control-label{
            font-weight: normal;
        }
        .importance{
            color: red;
        }
    </style>
</head>
<body>
    <div class="msg"></div>

    <div>
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
            <li><a href="#">员工管理</a></li>
            <li class="active">添加员工信息</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>
    <div class="col-sm-6">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/EmployeeServlet?${param.opt == null ? "opt=addEmployee":"opt=editEmployeeSave"}" method="post">
            <input type="hidden" name="id" value="${requestScope.employee.id}">
            <div class="form-group">
                <label for="userId" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>登录账户
                </label>
                <div class="col-sm-7">
                    <input type="text" name="userId" required pattern="^[a-z0-9_]{3,16}$" value="${requestScope.employee.userId}" class="form-control" id="userId" placeholder="登录账户,由字母、数字、下划线(3-16位)组成">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>登录密码
                </label>
                <div class="col-sm-7">
                    <input type="password" name="password" pattern="^[a-z0-9_]{6,18}$" required value="${requestScope.employee.password}" class="form-control" id="password" placeholder="登录密码,由字母、数字、下划线(6-18位)组成">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>员工电话
                </label>
                <div class="col-sm-7">
                    <input type="text" name="phone" required pattern="^1[34578]\d{9}$" value="${requestScope.employee.phone}" class="form-control" id="phone" placeholder="员工电话,有效的11位手机号">
                </div>
            </div>
            <div class="form-group">
                <label for="salary" class="col-sm-5 control-label text-right">工资</label>
                <div class="col-sm-7">
                    <input type="text" name="salary" value="${requestScope.employee.salary}" class="form-control" id="salary" placeholder="工资">
                </div>
            </div>
            <c:choose>
                <c:when test="${!empty requestScope.employee}">
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-7">
                            <button type="submit" name="sub" class="btn btn-primary">修改</button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-7">
                            <button type="submit" name="sub" class="btn btn-primary">添加</button>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </form>
    </div>
    <div class="footerMargin"></div>
    <script>
        $(function () {
            //添加刷新事件
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/EmployeeServlet"},refresh);
        })
    </script>
</body>
</html>
