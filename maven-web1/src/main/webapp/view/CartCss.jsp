<%@page import="Entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		tr {
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Cart</h1>
	<form action="<%= request.getContextPath() %>/CartServlet" method="post">
		<% ArrayList<Item> cart = (ArrayList<Item>) request.getAttribute("list");  %>
		<table border="1">
			<tr>
				<td>Masp</td>
				<td>Tensp</td>
				<td>Hinhsp</td>
				<td>Gia</td>
				<td>SoLuong</td>
				<td>Total</td>
				<td>Action</td>
			</tr>
			<c:forEach var="p" items="<%=cart %>">
				<tr>
					<td>${p.sanpham.masp }</td>
					<td>${p.sanpham.tensp }</td>
					<td><img src="<%= request.getContextPath() %>/resources/images/${p.sanpham.hinhsp }" height="150px" width="120px"></td>
					<td>${p.sanpham.giasp }</td>
					<td>${p.soluong }</td>
					<td>${p.sanpham.giasp * p.soluong }</td>
					<td><a href="<%= request.getContextPath() %>/CartServlet?action=delete&masp=${p.sanpham.masp }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<p> <b>Total: <%=request.getAttribute("total") %></b></p>
		<a href = "view/CustomerCss.jsp">Continue Shopping</a> |
		<a href = "<%= request.getContextPath() %>/CartServlet?action=removeAll">Remove all Items</a> | 
		<input type="submit" value="Purchase">
	</form>
</body>
</html>