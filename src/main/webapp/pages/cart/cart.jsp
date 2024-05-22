<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <%
        String usercart = (String)session.getAttribute("username") + "cart";
        pageContext.setAttribute("usercart", usercart);
    %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.get(pageScope.usercart).cartItems}">
            <tr>
                <td colspan="5">亲，当前购物车为空！</td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.get(pageScope.usercart).cartItems}">
            <c:forEach items="${sessionScope.get(pageScope.usercart).cartItems}" var="item">
                <tr>
                    <td>${item.value.name}</td>
                    <td>
						<a href="cartServlet?action=updateCount&count=${item.value.count - 1}&id=${item.value.id}">-</a>
							${item.value.count}
						<a href="cartServlet?action=updateCount&count=${item.value.count + 1}&id=${item.value.id}">+</a>
					</td>
                    <td>${item.value.price}</td>
                    <td>${item.value.totalprice}</td>
                    <td><a href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <div class="cart_info">
        <span class="cart_span">购物车中共有<span class="b_count">${not empty sessionScope.get(pageScope.usercart).totalCount ? sessionScope.get(pageScope.usercart).totalCount:0}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${not empty sessionScope.get(pageScope.usercart).totalPrice?sessionScope.get(pageScope.usercart).totalPrice:0}</span>元</span>
        <span class="cart_span"><a href="cartServlet?action=clear">清空购物车</a></span>
        <span class="cart_span"><a href="orderServlet?action=CreateOrder">去结账</a></span>
    </div>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>