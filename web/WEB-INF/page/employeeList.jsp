<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: xinqin
  Date: 2019/1/23
  Time: 16:53
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
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
    <style>
        .bg{
            background: #f3f3f3;
        }
        .table>tbody>tr>td{
            padding-left: 15px;
        }
        .count{
            height: 50px;
            line-height: 50px;
            margin-bottom: 10px;
            padding-left: 5px;
            font-size: 12px;
        }

    </style>
</head>
<body>

    <div class="msg">
        <c:if test="${!empty msg}">
            <span ${requestScope.flag==true ? "class='bg-success'":"class='bg-danger'"}>${msg}</span>
        </c:if>
    </div>

    <div>
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
            <li><a href="#">员工管理</a></li>
            <li class="active">员工列表</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>

    <div class="col-md-12">
        <form id="search" class="form-inline" action="${pageContext.request.contextPath}/EmployeeServlet?opt=searchEmployee" method="post">
            <div class="form-group">
                <input type="text" name="empId" class="form-control" value="${param.empId}" placeholder="员工编号" >
            </div>
            <div class="form-group">
                <input type="text" name="userId" class="form-control" value="${param.userId}" placeholder="登录账户" >
            </div>
            <div class="form-group">
                <input type="text" name="phone" class="form-control" value="${param.phone}" placeholder="员工电话">
            </div>
            <button type="submit" class="btn btn-default form-control">
                <span class="glyphicon glyphicon-search"></span>
            </button>
        </form>
    </div>

    <div class="col-md-12">
        <div class="bg count">
            共有数据: ${requestScope.page.total}条
        </div>
    </div>
    <div class="col-md-12">
        <table class="table table-hover table-bordered list">
            <tr class="bg">
                <td>确认号码</td>
                <td>员工编号</td>
                <td>登录账户</td>
                <td>员工手机号</td>
                <td>工资</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${requestScope.page.list}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.empId}</td>
                    <td>${employee.userId}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.salary}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/EmployeeServlet?opt=editEmployee&id=${employee.id}">
                            <span class="glyphicon glyphicon-list-alt" title="查看"></span>
                        </a>
                        &nbsp;
                        <a href="${pageContext.request.contextPath}/EmployeeServlet?opt=deleteEmployee&id=${employee.id}">
                            <span class="glyphicon glyphicon-trash" title="删除"></span>
                        </a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
    <nav class="text-center">
        <ul class="pagination">
            <c:choose>
                <c:when test="${requestScope.page.pageNum==1}">
                    <li class='disabled'}>
                        <a href="javascript:;">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a onClick="javascript:return checkvalue(this);" href="${pageContext.request.contextPath}/EmployeeServlet?opt=${param.opt}&pageNum=${requestScope.page.pageNum-1}">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
            <c:forEach items="${requestScope.page.navigatepageNums}" var="npn">
                <li ${requestScope.page.pageNum == npn ? "class='active'":""}>
                    <a onClick="javascript:return checkvalue(this);" href="${pageContext.request.contextPath}/EmployeeServlet?opt=${param.opt}&pageNum=${npn}">${npn}</a>
                </li>
            </c:forEach>
            <c:choose>
                <c:when test="${requestScope.page.pageNum==page.pages}">
                    <li class='disabled'}>
                        <a href="javascript:;">
                            <span>&raquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a onClick="javascript:return checkvalue(this);" href="${pageContext.request.contextPath}/EmployeeServlet?opt=${param.opt}&pageNum=${requestScope.page.pageNum+1}">
                            <span>&raquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
    <div class="footerMargin"></div>
    <script>

        $(function () {
            //添加刷新事件
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/EmployeeServlet?opt=employeeList"},refresh);
        })

    </script>
</body>
</html>
