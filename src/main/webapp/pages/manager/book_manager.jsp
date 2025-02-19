<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/pages/common/head.jsp" %>
    <script>
        $(function () {
            var target_a = $("a.deleteClass")
            target_a.click(function () {
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个是确认，一个是取消
                 * 返回true表示点击了确认，返回了false表示点击了取消
                 */
                return confirm("你确定要删除[" + $(this).parent().parent().find("td:first").text() + "]?")
                return false
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">图书管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.list}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
                <td><a href="manager/bookServlet?action=delete&id=${book.id}" class="deleteClass">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <a href="pages/manager/book_edit.jsp?method=add" methods="post">添加图书</a>
            </td>
        </tr>
    </table>
    <%@include file="/pages/common/page.jsp"%>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>