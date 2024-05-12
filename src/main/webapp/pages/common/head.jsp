<%--
  Created by IntelliJ IDEA.
  User: 20773
  Date: 2024/5/12
  Time: 上午10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String scheme = request.getScheme();
    String serverName = request.getServerName();
    int serverPort = request.getServerPort();
    String contextPath = request.getContextPath();
    String basePath = scheme + "://" + serverName + ':' + serverPort + contextPath + '/';
%>
<%=basePath%>

<base href="http://localhost:8080/BookStore/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/script/jquery-371.js"></script>