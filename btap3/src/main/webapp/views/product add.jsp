<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nliem
  Date: 13/05/2024
  Time: 4:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product/add" method="post">
    <label>Name</label>
    <input type="text" name="name"><br>
    <label>Price</label>
    <input type="text" name="price"><br>
    <label>Stock</label>
    <input type="text" name="stock"><br>
    <label>Category</label>
   <select name="categoryId">
       <c:forEach items="${categoryList}" var="cate" >
           <option value="${cate.id}">${cate.name}</option>
       </c:forEach>
   </select><br>
    <label>Status</label>
    <input type="radio" name="status" value="true"><span>Hien thi</span>
    <input type="radio" name="status" value="false"><span>An</span><br>
    <input type="submit" value="ADD">
</form>
</body>
</html>
