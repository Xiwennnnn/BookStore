<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城会员注册页面</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
    <script>
        $(function () {
            //1.给注册按钮绑定单击事件
            var regist_click = $("#sub_btn")
            regist_click.click(function () {
                //获取输入框用户名
                var unametxt = $("#username").val()
                var patt = /^\w{5,12}$/
                if (!patt.test(unametxt)) {
                    $("span.errorMsg").text("用户名不合法!")
                    return false
                }

                //2.获取输入密码
                var pwdtxt = $("#password").val()
                var pwdretxt = $("#repwd").val()
                if (!patt.test(pwdtxt)) {
                    $("span.errorMsg").text("密码不合法!")
                    return false
                }
                if (pwdtxt !== pwdretxt) {
                    $("span.errorMsg").text("密码不一致!")
                    return false
                }

                //3.确认邮箱
                var emailtxt = $("#email").val()
                var emailpatt = /^\w+@\w+.com$/
                if (!emailpatt.test(emailtxt)) {
                    $("span.errorMsg").text("邮箱不合法!")
                    return false
                }

                //4.验证码
                var codetxt = $("#code")
                if (codetxt.val() == null || codetxt.val() == "") {
                    $("span.errorMsg").text("验证码不能为空!")
                    return false
                }
                //5.去除错误信息
                $("span.errorMsg").text()
            })
        })
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册书城会员</h1>
                    <span class="errorMsg">
                        ${requestScope.msg }
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                               tabindex="1" name="username" id="username"
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                               tabindex="1" name="password" id="password"
                               value="${requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
                               tabindex="1" name="repwd" id="repwd"
                               value="${requestScope.repwd}"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
                               tabindex="1" name="email" id="email"
                               value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                        <a class="rt_login" href="pages/user/login.jsp">返回登录</a>
                    </form>

                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>