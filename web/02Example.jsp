<%@ page import="java.util.List" %>
<%@ page import="day10JSP.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 83731
  Date: 2017/09/10
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>引用实体类</title>
</head>
<body>
<%
    List<Student> students = new ArrayList<Student>();
    students.add(new Student("牛前", "你姐姐", 22));
    students.add(new Student("牛前", "你姐姐", 22));
    students.add(new Student("牛前", "你姐姐", 22));

%>

<%--表格的形式，打印出来--%>
<table border="1" width="438">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>

    <%
        for (Student student : students) {
    %>
    <tr>
        <td><%=student.getName()%>
        </td>
        <td><%=student.getGender()%>
        </td>
        <td><%=student.getAge()%>
        </td>
    </tr>

    <%
        }
    %>


</table>

</body>
</html>
