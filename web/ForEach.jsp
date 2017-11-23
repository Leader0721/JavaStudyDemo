<%--
  Created by IntelliJ IDEA.
  User: 83731
  Date: 2017/09/10
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("strs", new String[]{"1", "2"});

%>


<c:forEach items="${strs}" var="s">
    ${s}<br/>

</c:forEach>
</body>
</html>
