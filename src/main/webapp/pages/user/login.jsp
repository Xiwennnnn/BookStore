<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员登录页面</title>
    <%@include file="/pages/common/head.jsp" %>

</head>
<body>
<%!
	String cookie_uname;
    String cookie_pwd;
    String session_uname;
%>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("username")){
			cookie_uname = cookie.getValue();
		}
        if(cookie.getName().equals("password")){
            cookie_pwd = cookie.getValue();
        }
	}

    session_uname = (String)session.getAttribute("username");
    if(session_uname != null){
        response.sendRedirect(basePath+"index.jsp");
    }
%>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%></span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username"
                               value="<%=request.getAttribute("username")==null?
                               cookie_uname==null?"":cookie_uname:request.getAttribute("username")%>"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" value="<%=request.getAttribute("password")==null?
                               cookie_pwd==null?"":cookie_pwd:request.getAttribute("password")%>"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn_login"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>