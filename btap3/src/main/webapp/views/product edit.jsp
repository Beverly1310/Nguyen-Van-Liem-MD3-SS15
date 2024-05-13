<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nliem
  Date: 13/05/2024
  Time: 4:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product/edit" method="post">
    <label>ID</label>
    <input type="text" name="id" value="${product.id}" readonly><br>
    <label>Name</label>
    <input type="text" name="name" value="${product.name}"><br>
    <label>Price</label>
    <input type="text" name="price" value="${product.price}"><br>
    <label>Stock</label>
    <input type="text" name="stock" value="${product.stock}"><br>
    <label>Category</label>
    <select name="categoryId">
        <c:forEach items="${categoryList}" var="cate" >
            <option selected="${product.category.name==cate.name?"selected":""}" value="${cate.id}">${cate.name}</option>
        </c:forEach>
    </select><br>
    <label>Status</label>
    <input type="radio" name="status" ${product.status?"checked":""} value="true"><span>Hien thi</span>
    <input type="radio" name="status" ${!product.status?"checked":""} value="false"><span>An</span><br>
    <input type="submit" value="EDIT">
</form>
</body>
</html>
