<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20773
  Date: 2024/5/12
  Time: 上午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.username}</span>光临书城</span>
    <a href="${pageContext.request.contextPath}/pages/order/order.jsp">我的订单</a>
    <a href="${pageContext.request.contextPath}/userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/index.jsp">返回</a>
</div>