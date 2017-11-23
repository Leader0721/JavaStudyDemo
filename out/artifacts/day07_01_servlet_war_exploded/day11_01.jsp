<%@ page import="day11EL.Student" %><%--
  Created by IntelliJ IDEA.
  User: 83731
  Date: 2017/09/10
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取数据</title>
</head>
<body>
<%
    Student student = new Student();
    request.setAttribute("s", student);
%>

${s}
<hr/>
${s.name}=${s["name"]}=${s['name']}
<hr/>
${s.address.province}

</body>
</html>
