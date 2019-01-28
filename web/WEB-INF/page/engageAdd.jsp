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
            <li><a href="#">预订管理</a></li>
            <li class="active">添加预订信息</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>
    <div class="col-sm-6">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/EngageServlet?${param.opt == null ? "opt=addEngage":"opt=editEngageSave"}" method="post">
            <input type="hidden" name="id" value="${requestScope.engage.id}">
            <div class="form-group">
                <label for="username" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>客户姓名
                </label>
                <div class="col-sm-7">
                    <input type="text" name="username" required value="${requestScope.engage.name}" class="form-control" id="username" placeholder="客房姓名">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>客户电话
                </label>
                <div class="col-sm-7">
                    <input type="text" name="phone" required value="${requestScope.engage.phone}" class="form-control" id="phone" placeholder="客户电话">
                </div>
            </div>
            <div class="form-group">
                <label for="arriveTime" class="col-sm-5 control-label text-right">预抵时间</label>
                <div class="col-sm-7">
                    <input type="date" name="arriveTime" value="${requestScope.engage.arriveTime}" class="form-control" id="arriveTime">
                </div>
            </div>
            <div class="form-group">
                <label for="room" class="col-sm-5 control-label text-right">预订房号</label>
                <div class="col-sm-7">
                    <input type="text" name="room" value="${requestScope.engage.roomId}" class="form-control" id="room">
                </div>
            </div>
            <div class="form-group">
                <label for="mark" class="col-sm-5 control-label text-right">预订状态</label>
                <div class="col-sm-7">
                    <select name="mark" id="mark" class="form-control shortselect">
                        <option value="">请选择</option>
                        <option value="1" ${requestScope.engage.mark == 1 ? "selected" : ""}>确认</option>
                        <option value="2" <c:if test="${requestScope.engage.mark == 2}">selected</c:if>>取消</option>
                        <option value="3" ${requestScope.engage.mark == 3 ? "selected" : ""}>待定</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="remark" class="col-sm-5 control-label text-right">备注</label>
                <div class="col-sm-7">
                    <textarea name="remark" id="remark" rows="5" class="form-control">${requestScope.engage.remark}</textarea>
                </div>
            </div>
            <c:choose>
                <c:when test="${!empty requestScope.engage}">
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-7">
                            <button type="submit" name="sub" class="btn btn-primary">修改</button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-7">
                            <button type="submit" name="sub" class="btn btn-primary">预订</button>
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
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/EngageServlet"},refresh);
        })
    </script>
</body>
</html>
