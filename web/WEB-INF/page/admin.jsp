<%--
  Created by IntelliJ IDEA.
  User: xinqin
  Date: 2019/1/22
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- 顶部开始 -->
        <div class="container-fluid top">
            <div class="col-md-3">
                酒店预订管理系统
            </div>
            <div class="col-md-offset-7 col-md-2 text-right">
                你好,${sessionScope.user.userId} <span class="glyphicon glyphicon-triangle-bottom"></span>
            </div>
        </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
    <!-- 左侧菜单开始 -->
    <div class="container-fluid">
        <div id="side-nav" class="col-md-2">
            <ul class="nav_menu panel-group" id="accordion">
                <%-- 预定管理--%>
                <li class="panel panel-default">
                    <a class="nav_li" data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                        <span class="glyphicon glyphicon-phone-alt"></span>&nbsp;&nbsp;
                        <span>预订管理</span>
                    </a>
                    <ul class="sub-menu collapse" id="collapse1">
                        <li>
                            <a href="${pageContext.request.contextPath}/EngageServlet" target="engageAdd" index="engageAdd">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>添加预订信息</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/EngageServlet?opt=engageList" target="engageList" index="engageList">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>预订列表</span>
                            </a>
                        </li >
                    </ul>
                </li>

                <%-- 客房管理--%>
                <li class="panel panel-default">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse2" class="nav_li">
                        <span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;
                        <span>客房管理</span>
                    </a>
                    <ul class="sub-menu collapse" id="collapse2">
                        <li>
                            <a href="${pageContext.request.contextPath}/RoomServlet" target="roomAdd" index="roomAdd">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>客房录入</span>
                            </a>
                        </li >
                        <li>
                            <a href="${pageContext.request.contextPath}/RoomServlet?opt=roomList" target="roomList" index="roomList">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>客房列表</span>
                            </a>
                        </li >
                    </ul>
                </li>

                <%-- 会员管理--%>
                <li class="panel panel-default">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse3" class="nav_li">
                        <span class="glyphicon glyphicon-fire"></span>&nbsp;&nbsp;
                        <span>会员管理</span>
                    </a>
                    <ul class="sub-menu collapse" id="collapse3">
                        <li>
                            <a href="${pageContext.request.contextPath}/MemberServlet" target="memberAdd" index="memberAdd">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>会员录入</span>
                            </a>
                        </li >
                        <li>
                            <a href="${pageContext.request.contextPath}/MemberServlet?opt=memberList" target="memberList" index="memberList">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>会员列表</span>
                            </a>
                        </li >
                    </ul>
                </li>

                <%-- 入住管理--%>
                <li class="panel panel-default">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse4" class="nav_li">
                        <span class="glyphicon glyphicon-asterisk"></span>&nbsp;&nbsp;
                        <span>入住管理</span>
                    </a>
                    <ul class="sub-menu collapse" id="collapse4">
                        <li>
                            <a href="${pageContext.request.contextPath}/LiveServlet" target="liveAdd" index="liveAdd">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>添加入住信息</span>
                            </a>
                        </li >
                        <li>
                            <a href="${pageContext.request.contextPath}/LiveServlet?opt=liveList" target="liveList" index="liveList">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>入住列表</span>
                            </a>
                        </li>
                    </ul>
                </li>

                <%-- 结算管理--%>
                <li class="panel panel-default">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse5" class="nav_li">
                        <span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;
                        <span>结算管理</span>
                    </a>
                    <ul class="sub-menu collapse" id="collapse5">
                        <li>
                            <a href="javascript:;" target="checkoutList" index="checkoutList">
                                <span class="glyphicon glyphicon-menu-right"></span>
                                <span>结算列表</span>
                            </a>
                        </li>
                    </ul>
                </li>

                <%-- 员工管理--%>
                <li class="panel panel-default">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse6" class="nav_li">
                        <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;
                        <span>员工管理</span>
                    </a>
                    <ul class="sub-menu collapse" id="collapse6">
                        <li>
                            <a href="${pageContext.request.contextPath}/EmployeeServlet" target="empAdd" index="empAdd">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>员工添加</span>
                            </a>
                        </li >
                        <li>
                            <a href="${pageContext.request.contextPath}/EmployeeServlet?opt=employeeList" target="empList" index="empList">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>员工列表</span>
                            </a>
                        </li>
                    </ul>
                </li>

                <%-- 商品管理--%>
                <li class="panel panel-default">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse7" class="nav_li ">
                        <span class="glyphicon glyphicon-gift"></span>&nbsp;&nbsp;
                        <span>商品管理</span>
                    </a>
                    <ul class="sub-menu collapse" id="collapse7">
                        <li>
                            <a href="${pageContext.request.contextPath}/GoodsServlet" target="goodsAdd" index="goodsAdd">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>商品添加</span>
                            </a>
                        </li >
                        <li>
                            <a href="${pageContext.request.contextPath}/GoodsServlet?opt=goodsList" target="goodsList" index="goodsList">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>商品列表</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/GoodsServlet?opt=buyGoods" target="buyGoods" index="buyGoods">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>购买商品</span>
                            </a>
                        </li >
                        <li>
                            <a href="${pageContext.request.contextPath}/GoodsConsumeServlet?opt=consumeList" target="consumeList" index="consumeList">
                                <span class="glyphicon glyphicon-menu-right"></span>&nbsp;
                                <span>购买记录</span>
                            </a>
                        </li >
                    </ul>
                </li>
            </ul>
        </div>
        <!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="col-md-10 right">
            <div class="">
                <ul class="nav nav-tabs " id="navList">
                    <li class="list active">
                        <a href="#desktop" data-toggle="tab">
                            我的桌面&nbsp;
                            <%--<span class="close">&times;</span>--%>
                        </a>
                    </li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content" style="width: 100%;height: 630px;">
                    <div class="tab-pane active" id="desktop">
                        <iframe name="desktop" src='welcome.jsp' frameborder="0" scrolling="yes" style="max-width: 100%;width: 100%;height: 100%;"></iframe>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->

    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright"></div>
    </div>
    <!-- 底部结束 -->

    <script src="${pageContext.request.contextPath}/static/js/admin.js"></script>
    <script>

        $(".close").on("click",removeList);
        $(".sub-menu>li>a").on("click",copyIframeAndLi);

    </script>

</body>
</html>
