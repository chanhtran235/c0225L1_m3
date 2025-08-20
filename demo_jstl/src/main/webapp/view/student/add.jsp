<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
    <style>
        small {
            color: red;
        }
    </style>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<form action="/students?action=add" method="post">
    <h1>Thêm mới</h1>
    <div>
        <input id="name" onblur="checkValidate()" name="name" placeholder="Nhập tên"><br>
        <small id="nameError"></small>
    </div>
    <div>
        <input name="gender" type="radio" value="true" checked> Nam
        <input name="gender" type="radio" value="false"> Nữ
    </div>
    <div>
        <input  id="score" onblur="checkValidate()" name="score" placeholder="nhập điểm"><br>
        <small id="scoreError"></small>
    </div>
    <div>
        <select  id="classId" name="classId">
            <option value="">-------Chọn lớp-------</option>
            <c:forEach items="${classList}" var="cls">
                <option value="${cls.id}">${cls.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button id="btn-save" disabled type="submit"> Lưu</button>
    </div>
</form>
<script>
    function checkValidate(){
        let name = document.getElementById("name").value;
        let score = document.getElementById("score").value;
        let classId = document.getElementById("classId").value;
        let regexName = /^[A-Z][a-z]*(\s[A-Z][a-z]*)+$/;
        let isValidate = true;
        if (name ==""){
            document.getElementById("nameError").innerText = "Tên không được để trống";
            isValidate = false;
        }else if (!regexName.test(name)){
            document.getElementById("nameError").innerText = "Tên không đúng định dạng";
            isValidate = false;
        } else {
            document.getElementById("nameError").innerText = "";
            isValidate = true;
        }
        if (score ==""){
            document.getElementById("scoreError").innerText = "Điểm không được để trống";
            isValidate = false;
        }else {
            document.getElementById("scoreError").innerText = "";
            isValidate = true;
        }
        if (isValidate){
            document.getElementById("btn-save").disabled =false;
        }


    }
</script>
</body>
</html>
