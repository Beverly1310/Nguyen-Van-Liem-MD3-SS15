<%--
  Created by IntelliJ IDEA.
  User: nliem
  Date: 13/05/2024
  Time: 2:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/cal">
    <input type="text" name="firstNumber" placeholder="So thu nhat">
    <input type="text" name="secondNumber" placeholder="So thu hai"><br>
    <input type="submit" name="cal" value="+">
    <input type="submit" name="cal" value="-">
    <input type="submit" name="cal" value="*">
    <input type="submit" name="cal" value="/">
</form>
<h3>Result: ${result}</h3>
</body>
</html>
