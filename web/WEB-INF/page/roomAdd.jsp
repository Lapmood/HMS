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
            <li><a href="#">客房管理</a></li>
            <li class="active">客房录入</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>
    <div class="">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/RoomServlet?${param.opt == null ? "opt=addRoom":"opt=editRoomSave"}" method="post">
            <input type="hidden" name="id" value="${requestScope.room.id}">
            <div class="form-group col-md-5">
                <label for="roomId" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>客房号
                </label>
                <div class="col-md-6">
                    <input type="text" name="roomId" value="${requestScope.room.roomId}" required class="form-control" id="roomId" placeholder="客房号">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="roomType" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>客房类型
                </label>
                <div class="col-md-6">
                    <select name="roomType" id="roomType" class="form-control" required>
                        <option value="">请选择</option>
                        <option value="单间" ${fn:contains(requestScope.room.roomType,"单间") ? "selected" : ""}>单间</option>
                        <option value="双间" ${fn:contains(requestScope.room.roomType,"双间") ? "selected" : ""}>双间</option>
                        <option value="大床房" ${fn:contains(requestScope.room.roomType,"大床房") ? "selected" : ""}>大床房</option>
                        <option value="豪华客房" ${fn:contains(requestScope.room.roomType,"豪华客房") ? "selected" : ""}>豪华客房</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="state" class="col-md-4 control-label text-right">客房状态</label>
                <div class="col-md-6">
                    <select name="state" id="state" class="form-control" required>
                        <option value="">请选择</option>
                        <option value="空闲" ${fn:contains(requestScope.room.state,"空闲") ? "selected" : ""}>空闲</option>
                        <option value="维修" ${fn:contains(requestScope.room.state,"维修") ? "selected" : ""}>维修</option>
                        <option value="已入住" ${fn:contains(requestScope.room.state,"已入住") ? "selected" : ""}>已入住</option>
                        <option value="废弃" ${fn:contains(requestScope.room.state,"废弃") ? "selected" : ""}>废弃</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="location" class="col-md-4 control-label text-right">客房位置</label>
                <div class="col-md-6">
                    <input type="text" name="location" value="${requestScope.room.location}" class="form-control" required id="location" placeholder="客房位置">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="tele" class="col-md-4 control-label text-right">客房电话</label>
                <div class="col-md-6">
                    <input type="text" name="tele" value="${requestScope.room.location}" class="form-control" id="tele" placeholder="客房电话">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="bed" class="col-md-4 control-label text-right">床位数</label>
                <div class="col-md-6">
                    <input type="number" name="bed" required value="${requestScope.room.bed}" class="form-control" id="bed" required placeholder="床位数">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="price" class="col-md-4 control-label text-right">客房价格</label>
                <div class="col-md-6">
                    <input type="number" name="price" required value="${requestScope.room.price}" class="form-control" id="price" placeholder="客房价格">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="hourRoom" class="col-md-4 control-label text-right">是否钟点房</label>
                <div class="col-md-6">
                    <select name="hourRoom" id="hourRoom" class="form-control">
                        <option value="">请选择</option>
                        <option value="1" ${requestScope.room.hourRoom == 1 ? "selected" : ""}>是</option>
                        <option value="0" ${requestScope.room.hourRoom == 0 ? "selected" : ""}>否</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="hourPrice" class="col-md-4 control-label text-right">钟点房价格</label>
                <div class="col-md-6">
                    <input type="number" name="hourPrice" value="${requestScope.room.hourPrice}" class="form-control" id="hourPrice" placeholder="钟点房价格">
                </div>
            </div>

            <div class="form-group col-md-5">
                <label for="remark" class="col-md-4 control-label text-right">备注</label>
                <div class="col-md-8">
                    <textarea name="remark" rows="3" class="form-control" id="remark">${requestScope.room.remark}</textarea>
                </div>
            </div>
            <c:choose>
                <c:when test="${!empty requestScope.room}">
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
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/RoomServlet"},refresh);
        })
    </script>
</body>
</html>
