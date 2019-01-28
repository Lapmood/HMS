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
            <li><a href="#">会员管理</a></li>
            <li class="active">会员录入</li>
            <span class="btn btn-primary">刷新</span>
        </ol>
    </div>
    <div class="">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/MemberServlet?${param.opt == null ? "opt=addMember":"opt=editMemberSave"}" method="post">
            <input type="hidden" name="id" value="${requestScope.member.id}">
            <div class="form-group col-md-5">
                <label for="memberId" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>会员编号
                </label>
                <div class="col-md-6">
                    <input type="text" name="memberId" value="${requestScope.member.memberId}" required class="form-control" id="memberId" placeholder="会员编号">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="memberName" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>会员姓名
                </label>
                <div class="col-md-6">
                    <input type="text" name="memberName" value="${requestScope.member.memberName}" required class="form-control" id="memberName" placeholder="会员姓名">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="memberType" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>会员类型
                </label>
                <div class="col-md-6">
                    <select name="memberType" id="memberType" class="form-control" required>
                        <option value="">请选择</option>
                        <c:forEach items="${requestScope.memberTypes}" var="memberT">
                            <option value="${memberT.id}" ${requestScope.member.memberType == memberT.id ? "selected" : ""}>${memberT.type}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="sex" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>会员性别
                </label>
                <div class="col-md-6">
                    <input type="text" name="sex" id="sex" value="${requestScope.member.sex}" required class="form-control" placeholder="会员性别">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="idCard" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>会员身份证
                </label>
                <div class="col-md-6">
                    <input type="text" name="idCard" id="idCard" value="${requestScope.member.idCard}" required class="form-control" placeholder="会员身份证">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="address" class="col-md-4 control-label text-right">
                    会员地址
                </label>
                <div class="col-md-6">
                    <input type="text" name="address" id="address" value="${requestScope.member.address}" class="form-control" placeholder="会员地址">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="status" class="col-md-4 control-label text-right">会员状态</label>
                <div class="col-md-6">
                    <select name="status" id="status" class="form-control" required>
                        <option value="">请选择</option>
                        <option value="激活" ${fn:contains(requestScope.member.status,"激活") ? "selected" : ""}>激活</option>
                        <option value="未激活" ${fn:contains(requestScope.member.status,"未激活") ? "selected" : ""}>未激活</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="phone" class="col-md-4 control-label text-right">
                    <span class="importance">*</span>会员电话
                </label>
                <div class="col-md-6">
                    <input type="text" name="phone" id="phone" required value="${requestScope.member.phone}" class="form-control" placeholder="会员电话">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="balance" class="col-md-4 control-label text-right">会员余额</label>
                <div class="col-md-6">
                    <input type="number" name="balance" required value="${requestScope.member.balance}" class="form-control" id="balance" placeholder="会员余额">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="totalMoney" class="col-md-4 control-label text-right">总消费</label>
                <div class="col-md-6">
                    <input type="number" name="totalMoney" value="${requestScope.member.totalMoney}" disabled class="form-control" id="totalMoney" placeholder="总消费">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="remark" class="col-md-4 control-label text-right">备注</label>
                <div class="col-md-8">
                    <textarea name="remark" rows="3" class="form-control" id="remark">${requestScope.member.remark}</textarea>
                </div>
            </div>
            <c:choose>
                <c:when test="${!empty requestScope.member}">
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
            $(".breadcrumb span").on("click",{href:"${pageContext.request.contextPath}/MemberServlet"},refresh);
        })
    </script>
</body>
</html>
