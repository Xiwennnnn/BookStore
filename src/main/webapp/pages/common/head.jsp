<%--
  Created by IntelliJ IDEA.
  User: 20773
  Date: 2024/5/12
  Time: 上午10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String scheme = request.getScheme();//获取协议
    String serverName = request.getServerName();//获取服务器ip
    int serverPort = request.getServerPort();//获取端口号
    String contextPath = request.getContextPath();//获取根路径
    String basePath = scheme + "://" + serverName + ':' + serverPort + contextPath + '/';
%>
<%=basePath%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/script/jquery-371.js"></script>