<%--
  Created by IntelliJ IDEA.
  User: mohd
  Date: 16/10/18
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success StudentCo</title>
</head>
<body>
<form method="post" action="/successcoForm.html">
<table>
    <tr>
        <td>Student First Name : ${student.firstName}</td>
    </tr>
    <tr>
        <td>Last Name : ${student.lastName}</td>
    </tr>
</table>
</form>
</body>
</html>
