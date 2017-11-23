<%--
  Created by IntelliJ IDEA.
  User: 83731
  Date: 2017/11/05
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="checkbox" name="auto"/>记住我<br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
