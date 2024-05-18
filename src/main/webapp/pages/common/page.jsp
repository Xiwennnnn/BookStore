<%--
  Created by IntelliJ IDEA.
  User: 20773
  Date: 2024/5/17
  Time: 下午8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>

    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
        <c:if test="${requestScope.page.pageNo > 2}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 2}">${requestScope.page.pageNo - 2}</a>
        </c:if>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">${requestScope.page.pageNo - 1}</a>
    </c:if>
    【${requestScope.page.pageNo}】
    <c:if test="${requestScope.page.pageNo < requestScope.page.totalPage}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">${requestScope.page.pageNo + 1}</a>
        <c:if test="${requestScope.page.pageNo < requestScope.page.totalPage - 1}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 2}">${requestScope.page.pageNo + 2}</a>
        </c:if>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
    </c:if>

    <a href="${requestScope.page.url}&pageNo=${requestScope.page.totalPage}">末页</a>
    共${requestScope.page.totalPage}页，${requestScope.page.totalCount}条记录 到第
    <input type="text" name="pn" id="pn_input"/>
    <input type="button" value="确定" id="searchPageNo"/>
    页
    <script>
        $(function () {
            var button = $("#searchPageNo");
            button.click(function () {
                var pageNo = $("#pn_input").val();
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            });
        })
    </script>
</div>