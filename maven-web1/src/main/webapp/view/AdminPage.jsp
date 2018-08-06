<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="Model.ProductModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		th {
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Welcome Admin: Product Page</h1>
	<table border="1">
		<tr>
			<th>Masp</th>
			<th>Tensp</th>
			<th>Gia</th>
			<th>Hinh</th>
			<th>Update Product</th>
			<th>Delete Product</th>
		</tr>
		<% ProductModel proModel = new ProductModel(); %>
		<c:forEach var="p" items="<%=proModel.getList() %>">
			<tr>
				<td>${p.masp }</td>
				<td>${p.tensp }</td>
				<td>${p.giasp }</td>
				<td><img src="Images/${p.hinhsp }" height="150px" width="120px"></td>
				<c:url var="varUpdate" value="UpdateProduct.jsp">
					<c:param name="masp" value="${p.masp }"/>
					<c:param name="tensp" value="${p.tensp }"/>
					<c:param name="giasp" value="${p.giasp }"/>
					<c:param name="hinhsp" value="${p.hinhsp }"/>
					<c:param name="madm" value="${p.madm }"/>
				</c:url>
				<td><a href="${varUpdate }">Update Product</a></td>
				<c:url var="varDelete" value="ProductServlet">
					<c:param name="masp" value="${p.masp }"/>
					<c:param name="action" value="deletePart"/>
				</c:url>
				<td><a href="${varDelete }">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
		</tr>
	</table>
	<br>
	<a href="InsertProduct.jsp">Insert</a> |
	<c:url var="varClear" value="ProductServlet">
		<c:param name="action" value="clearList"/>
	</c:url>
	<a href="${varClear }">Clear List</a>
</body>
</html>