
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<form action="/students?action=add" method="post">
    <h1>Thêm mới</h1>
<%--    <input name="id" placeholder="Nhập id"><br>--%>
    <input name="name" placeholder="Nhập tên"><br>
    <input name="gender" type="radio" value="true"> Nam
    <input name="gender" type="radio" value="false"> Nữ<br>
    <input name="score" placeholder="nhập điểm"><br>
    <button type="submit"> Lưu</button>
</form>
</body>
</html>
