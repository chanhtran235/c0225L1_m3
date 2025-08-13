<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <p>${param.mess}</p>
    <a href="/students?action=add">Thêm mới</a>
    <table class="table table-dark table-striped">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
            <th>Chỉnh sửa</th>
            <th>Xoá</th>
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
                <td>
                    <button class="btn btn-sm btn-primary">Chỉnh sửa</button>
                </td>
                <td>
                    <button onclick="getInfoDelete('${student.getId()}','${student.getName()}')" data-bs-toggle="modal"
                            data-bs-target="#deleteModal" class="btn btn-sm btn-danger">Xoá
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/students?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input hidden="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá sinh viên </span>
                    <span style="color: red" id="deleteName"></span>
                    <span> không???</span>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button type="submit" class="btn btn-primary">Xoá</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function getInfoDelete(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }
</script>
</body>
</html>
