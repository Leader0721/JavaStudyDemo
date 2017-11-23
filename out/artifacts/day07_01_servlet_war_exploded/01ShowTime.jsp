<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 83731
  Date: 2017/09/10
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示时间</title>
</head>
<body>
    现在是北京时间:
    <%

        Date now = new Date();
        System.out.println(now.toLocaleString());

    %>
</body>
</html>
