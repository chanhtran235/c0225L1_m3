<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 8/6/2025
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<div>
    <h1>Danh sách sinh viên</h1>
    <table class="table table-dark table-striped">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
        </tr>
        <c:forEach var="student" items="${studentList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${student.getName()}"></c:out></td>
                <td>
                    <c:if test="${student.isGender()}">
                        Nam
                    </c:if>
                    <c:if test="${!student.isGender()}">
                        Nữ
                    </c:if>
                </td>
                <td>${student.getScore()}</td>
                <td>
                    <c:choose>
                        <c:when test="${student.getScore()>=8}">
                            Giỏi
                        </c:when>
                        <c:when test="${student.getScore()>=7}">
                            Khá
                        </c:when>
                        <c:when test="${student.getScore()>=5}">
                            Trung Bình
                        </c:when>
                        <c:otherwise>
                            Yêu sắc yếu
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
