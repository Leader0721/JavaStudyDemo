<%--
  Created by IntelliJ IDEA.
  User: 83731
  Date: 2017/11/05
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自动登录</title>
</head>
<body>
<c:if test="${sessionScope.user == null}">
    <a href="${pageContext.request.contextPath}/autologin.jsp">登录</a>
</c:if>
<c:if test="${sessionScope.user == null}">
    欢迎您:${sessionScope.user.nickname}
    <a href="#">注销</a>
</c:if>


</body>
</html>