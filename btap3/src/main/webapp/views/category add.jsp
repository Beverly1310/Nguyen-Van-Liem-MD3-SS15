<%--
  Created by IntelliJ IDEA.
  User: nliem
  Date: 13/05/2024
  Time: 4:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/category/add" method="post">
    <label>Name</label>
    <input type="text" name="name"><br>
    <label>Status</label>
    <input type="radio" checked name="status" value="true"><span>Hien thi</span>
    <input type="radio" name="status" value="false"><span>An</span><br>
    <input type="submit" value="ADD">
</form>
</body>
</html>
