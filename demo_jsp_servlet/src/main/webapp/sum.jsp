<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 8/4/2025
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  float num1 = Float.parseFloat(request.getParameter("number1"));
  float num2 = Float.parseFloat(request.getParameter("number2"));
  float sum = num1+num2;
  request.setAttribute("num1",num1);
  request.setAttribute("num2",num2);
  request.setAttribute("sum",sum);
  request.getRequestDispatcher("/form.jsp").forward(request,response);
%>
</body>
</html>
