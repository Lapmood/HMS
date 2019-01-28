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
            <li><a href="#">商品管理</a></li>
            <li class="active">商品添加</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>
    <div class="col-sm-6">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/GoodsServlet?${param.opt == null ? "opt=addGoods":"opt=editGoodsSave"}" method="post">
            <input type="hidden" name="id" value="${requestScope.goods.id}">
            <div class="form-group">
                <label for="name" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>商品名
                </label>
                <div class="col-sm-7">
                    <input type="text" name="name" required value="${requestScope.goods.name}" class="form-control" id="name" placeholder="商品名">
                </div>
            </div>
            <div class="form-group">
                <label for="price" class="col-sm-5 control-label text-right">商品价格</label>
                <div class="col-sm-7">
                    <input type="number" name="price" value="${requestScope.goods.price}" required class="form-control" id="price" placeholder="商品价格">
                </div>
            </div>
            <div class="form-group">
                <label for="number" class="col-sm-5 control-label text-right">商品数量</label>
                <div class="col-sm-7">
                    <input type="number" name="number" value="${requestScope.goods.number}" required class="form-control" id="number" placeholder="商品数量">
                </div>
            </div>
            <div class="form-group">
                <label for="purpose" class="col-sm-5 control-label text-right">商品用途</label>
                <div class="col-sm-7">
                    <textarea name="purpose" id="purpose" rows="5" class="form-control">${requestScope.goods.purpose}</textarea>
                </div>
            </div>
            <c:choose>
                <c:when test="${!empty requestScope.goods}">
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
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/GoodsServlet"},refresh);
        })
    </script>
</body>
</html>
