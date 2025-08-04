<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 8/4/2025
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tính tổng</title>
</head>
<body>
<form action="/sum" method="post">
    <input name="number1" value="${num1}" placeholder="nhập số thứ nhất">
    <input name="number2" value="${num2}" placeholder="nhập số thứ hai">
    <button type="submit">Tính Tổng</button>
    <p>Kết  quả : ${sum}</p>
</form>
</body>
</html>
