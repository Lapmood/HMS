<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <li><a href="#">客房管理</a></li>
            <li class="active">客房列表</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>

    <div class="col-md-12">
        <form id="search" class="form-inline" action="${pageContext.request.contextPath}/RoomServlet?opt=searchRoom" method="post">
            <div class="form-group">
                <input type="text" name="roomId" class="form-control" value="${param.roomId}" placeholder="客房编号" >
            </div>
            <div class="form-group">
                <select name="roomType" id="roomType" class="form-control">
                    <option value="">客房类型</option>
                    <option value="单间" ${fn:contains(param.roomType,"单间") ? "selected" : ""}>单间</option>
                    <option value="双间" ${fn:contains(param.roomType,"双间") ? "selected" : ""}>双间</option>
                    <option value="大床房" ${fn:contains(param.roomType,"大床房") ? "selected" : ""}>大床房</option>
                    <option value="豪华客房" ${fn:contains(param.roomType,"豪华客房") ? "selected" : ""}>豪华客房</option>
                </select>
            </div>
            <div class="form-group">
                <select name="state" id="state" class="form-control">
                    <option value="">客房状态</option>
                    <option value="空闲" ${fn:contains(param.state,"空闲") ? "selected" : ""}>空闲</option>
                    <option value="维修" ${fn:contains(param.state,"维修") ? "selected" : ""}>维修</option>
                    <option value="已入住" ${fn:contains(param.state,"已入住") ? "selected" : ""}>已入住</option>
                    <option value="废弃" ${fn:contains(param.state,"废弃") ? "selected" : ""}>废弃</option>
                </select>
            </div>
            <div class="form-group">
                <input type="text" name="location" class="form-control" value="${param.location}" placeholder="客房地址">
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
                <td>客房号</td>
                <td>客房类型</td>
                <td>客房状态</td>
                <td>客房位置</td>
                <td>床位数</td>
                <td>单价</td>
                <td>钟点房</td>
                <td>钟点房价</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${requestScope.page.list}" var="room">
                <tr>
                    <td>${room.roomId}</td>
                    <td>${room.roomType}</td>
                    <td>${room.state}</td>
                    <td>${room.location}</td>
                    <td>${room.bed}</td>
                    <td>${room.price}</td>
                    <td>${room.hourRoom == 1 ? "是":"否"}</td>
                    <td>${room.hourPrice}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/RoomServlet?opt=editRoom&id=${room.id}">
                            <span class="glyphicon glyphicon-list-alt" title="查看"></span>
                        </a>
                        &nbsp;
                        <a href="${pageContext.request.contextPath}/RoomServlet?opt=deleteRoom&id=${room.id}">
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
                        <a onClick="javascript:return checkvalue(this);" href="${pageContext.request.contextPath}/RoomServlet?opt=${param.opt}&pageNum=${requestScope.page.pageNum-1}">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
            <c:forEach items="${requestScope.page.navigatepageNums}" var="npn">
                <li ${requestScope.page.pageNum == npn ? "class='active'":""}>
                    <a onClick="javascript:return checkvalue(this);" href="${pageContext.request.contextPath}/RoomServlet?opt=${param.opt}&pageNum=${npn}">${npn}</a>
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
                        <a onClick="javascript:return checkvalue(this);" href="${pageContext.request.contextPath}/RoomServlet?opt=${param.opt}&pageNum=${requestScope.page.pageNum+1}">
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
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/RoomServlet?opt=roomList"},refresh);
        })

    </script>
</body>
</html>
