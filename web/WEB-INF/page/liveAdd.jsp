<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <li><a href="#">入住管理</a></li>
            <li class="active">添加入住信息</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>
    <div class="">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/LiveServlet?${param.opt == null ? "opt=addLive":"opt=editLiveSave"}" method="post">
            <input type="hidden" name="id" value="${requestScope.live.id}">
            <div class="form-group col-md-5">
                <label for="inNo" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>入住单号
                </label>
                <div class="col-md-6">
                    <input type="text" name="inNo" value="${requestScope.live.inNo}" required class="form-control" id="inNo" placeholder="入住单号">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="roomId" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>客房编号
                </label>
                <div class="col-md-6">
                    <input type="text" name="roomId" value="${requestScope.live.roomId}" required class="form-control" id="roomId" placeholder="客房编号">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="customerName" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>客户名称
                </label>
                <div class="col-md-6">
                    <input type="text" name="customerName" value="${requestScope.live.customerName}" required class="form-control" id="customerName" placeholder="客户名称">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="sex" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>客户性别
                </label>
                <div class="col-md-6">
                    <input type="text" name="sex" id="sex" value="${requestScope.live.sex}" required class="form-control" placeholder="客户性别">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="zjType" class="col-md-4 control-label text-right">证件类型</label>
                <div class="col-md-6">
                    <select name="zjType" id="zjType" class="form-control" required>
                        <option value="">请选择</option>
                        <option value="身份证" ${fn:contains(requestScope.live.zjType,"身份证") ? "selected" : ""}>身份证</option>
                        <option value="护照" ${fn:contains(requestScope.live.zjType,"护照") ? "selected" : ""}>护照</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="zjNo" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>证件编号
                </label>
                <div class="col-md-6">
                    <input type="text" name="zjNo" id="zjNo" value="${requestScope.live.zjNo}" required class="form-control" placeholder="证件编号">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="number" class="col-md-4 control-label text-right">
                    人数
                </label>
                <div class="col-md-6">
                    <input type="number" name="number" id="number" required value="${requestScope.live.number}" class="form-control" placeholder="人数">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="days" class="col-md-4 control-label text-right">
                    预住天数
                </label>
                <div class="col-md-6">
                    <input type="number" name="days" id="days" value="${requestScope.live.days}" class="form-control" placeholder="预住天数">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="foreGift" class="col-md-4 control-label text-right">押金</label>
                <div class="col-md-6">
                    <input type="number" name="foreGift" required value="${requestScope.live.foreGift}" class="form-control" id="foreGift" placeholder="押金">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="remark" class="col-md-4 control-label text-right">备注</label>
                <div class="col-md-8">
                    <textarea name="remark" rows="3" class="form-control" id="remark">${requestScope.live.remark}</textarea>
                </div>
            </div>
            <c:choose>
                <c:when test="${!empty requestScope.live}">
                    <div class="form-group col-md-12">
                        <div class="col-sm-offset-5">
                            <button type="submit" name="sub" class="btn btn-primary">修改</button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="form-group col-md-12">
                        <div class="col-sm-offset-5">
                            <button type="submit" name="sub" class="btn btn-primary">录入</button>
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
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/LiveServlet"},refresh);
        })
    </script>
</body>
</html>
