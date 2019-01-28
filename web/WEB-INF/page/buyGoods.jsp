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
            <li class="active">购买</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>
    <div class="col-sm-6">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/GoodsConsumeServlet?opt=saveBuyGoods" method="post">
            <div class="form-group">
                <label for="goodId" class="col-md-5 control-label text-right">
                    <span class="importance">*</span>商品
                </label>
                <div class="col-md-6">
                    <select name="goodId" id="goodId" class="form-control" required>
                        <option value="">请选择商品</option>
                        <c:forEach items="${requestScope.goods}" var="good">
                            <option value="${good.id}" price="${good.price}">${good.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="roomId" class="col-md-5 control-label text-right">
                    <span class="importance">*</span>客房
                </label>
                <div class="col-md-6">
                    <select name="roomId" id="roomId" class="form-control" required>
                        <option value="">请选择客房</option>
                        <c:forEach items="${requestScope.lives}" var="live">
                            <option value="${live.id}">${live.roomId}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="number" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>购买数量
                </label>
                <div class="col-sm-6">
                    <input type="number" min="0" name="number" value="1" required class="form-control" id="number" placeholder="购买数量">
                </div>
            </div>
            <div class="form-group">
                <label for="money" class="col-sm-5 control-label text-right">
                    <span class="importance">*</span>总金额
                </label>
                <div class="col-sm-6 input-group" style="padding:0px 15px">
                    <div class="input-group-addon">元</div>
                    <input type="text" disabled required class="form-control" id="money" placeholder="总金额">
                    <input type="hidden" name="money" value="0">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-5 col-sm-7">
                    <button type="submit" name="sub" class="btn btn-primary">购买</button>
                </div>
            </div>
        </form>
    </div>
    <div class="footerMargin"></div>
    <script>
        $(function () {
            //添加刷新事件
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/GoodsServlet?opt=buyGoods"},refresh);

            $("#goodId").change(calcAllMoney);
            $("#number").change(calcAllMoney);
        })

        //计算购买商品的总价格
        function calcAllMoney(){
            var price = $("#goodId :selected").attr("price");
            var number = $("#number").val();
            if(price){
                $("#money").val(price*number);
                $("input:hidden[name='money']").val(price*number);
            }
        }
    </script>
</body>
</html>
