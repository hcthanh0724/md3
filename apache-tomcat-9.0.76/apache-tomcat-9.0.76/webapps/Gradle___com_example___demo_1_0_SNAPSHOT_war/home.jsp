<%@ page import="com.example.demo.manager.ManagerNhanVien" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.demo.model.NhanVien" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 23/06/2023
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Danh sách người yêu của Nhân Viên</h2>
    <p>The .table-striped class adds zebra-stripes to a table:</p>
    <a href='/createNV'  class="btn btn-success">Create Nhân Viên</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Img</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nv" items="${nhanviens}">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.name}</td>
                <td><img src="${nv.img}" width="200" height="160"></td>
                <td><a href="/editNV?id=${nv.id}" class="btn btn-warning">Edit</a></td>
                <td><a href="/deleteNV?id=${nv.id}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>

