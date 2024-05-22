<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城</title>
    <%@include file="/pages/common/head.jsp" %>
    <script>
        $(function () {
            $(".add_cart").click(function () {
                var id = $(this).attr("bookId");
                location.href = "${pageScope.basePath}cartServlet?action=addItem&id=" + id;
            });
        });
    </script>
    <%
        String usercart = (String)session.getAttribute("username") + "cart";
        pageContext.setAttribute("usercart", usercart);
    %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.username}">
            <%--            如果还没登录--%>
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.username}">
            <%--            如果已经登录--%>
            <span>欢迎<span class="um_span">${sessionScope.username}</span>光临书城</span>
            <a href="${pageContext.request.contextPath}/pages/order/order.jsp">我的订单</a>
            <a href="pages/cart/cart.jsp">购物车</a>
            <a href="${pageContext.request.contextPath}/userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="clientBookServlet" method="get">
                <input type="hidden" name="action" value="getPageByPrice"/>
                价格：<input id="min" type="text" name="min" value="${param.startPrice}"> 元 -
                <input id="max" type="text" name="max" value="${param.endPrice}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <c:if test="${not empty sessionScope.username}">
            <div style="text-align: center">
                <span>您的购物车中有${not empty sessionScope.get(pageScope.usercart).totalCount ? sessionScope.get(pageScope.usercart).totalCount : 0}件商品</span>
                <c:if test="${not empty sessionScope.get(pageScope.usercart).lastname}">
                    <div>
                        您刚刚将<span style="color: red">${sessionScope.get(pageScope.usercart).lastname}</span>加入到了购物车中
                    </div>
                </c:if>
            </div>
        </c:if>
        <c:forEach items="${requestScope.page.list}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <c:if test="${not empty sessionScope.username}">
                        <div class="book_add">
                            <button bookId="${book.id}" class="add_cart">加入购物车</button>
                        </div>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
    <%@include file="/pages/common/page.jsp" %>
</div>
</body>
<%@include file="/pages/common/footer.jsp" %>
</html>