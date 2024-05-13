<%--
  Created by IntelliJ IDEA.
  User: nliem
  Date: 13/05/2024
  Time: 4:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/category/edit" method="post">
    <label>ID</label>
    <input type="text" name="id" value="${category.id}" readonly><br>
    <label>Name</label>
    <input type="text" name="name" value="${category.name}"><br>
    <label>Status</label>
    <input type="radio" name="status" ${category.status?"checked":""} value="true"><span>Hien thi</span>
    <input type="radio" name="status" ${!category.status?"checked":""} value="false"><span>An</span><br>
    <input type="submit" value="EDIT">
</form>
</body>
</html>
