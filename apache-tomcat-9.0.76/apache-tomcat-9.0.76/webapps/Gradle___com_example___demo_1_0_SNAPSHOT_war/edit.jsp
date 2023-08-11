<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 23/06/2023
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/editNV" method="post">
    <input name="id"  value="${nhanvien.id}" hidden="hidden"> <br>
    <input name="name" value="${nhanvien.name}"> <br>
    <input name="img" value="${nhanvien.img}"> <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
