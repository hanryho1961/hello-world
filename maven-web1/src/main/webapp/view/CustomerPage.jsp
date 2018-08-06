<%@page import="Model.ProductModel"%>
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
	<div id="container">
		<p id="name">Products Page</p>
		
		<% 
			ProductModel proModel = new ProductModel();
			int found = 0;
			int count = 0;
		%>
		<c:forEach var="p" items="<%=proModel.getList() %>">
			<% if (count == 5) {%>
				<%
					found = 0;
				%>
			<%} %>
			
			<% if (found == 0) {%>
				<div id="col1">
					<img src="Images/${p.hinhsp }" height="70px" width="62px" id="image1">
					<p id="masp">${p.masp }</p> 
					<p id="tensp">${p.tensp }</p> 
					<p id="giasp">$${p.giasp }</p>
					<c:url var="varUpdate" value="UpdateProduct.jsp">
						<c:param name="masp" value="${p.masp }"/>
						<c:param name="tensp" value="${p.tensp }"/>
						<c:param name="giasp" value="${p.giasp }"/>
						<c:param name="hinhsp" value="${p.hinhsp }"/>
						<c:param name="madm" value="${p.madm }"/>
					</c:url>
					<a href="${varUpdate }" id="updatepart">Update Product</a> |
					<c:url var="varDelete" value="ProductServlet">
						<c:param name="masp" value="${p.masp }"/>
						<c:param name="action" value="deletePart"/>
					</c:url>
					<a href="${varDelete }" id="deletepart">Delete</a>
				</div>
				<%
					found = 1; 
					count += 1;
				%>
			<%} else if (found == 1) {%>
				<div id="col2">
					<img src="Images/${p.hinhsp }" height="70px" width="62px" id="image2">
					<p id="masp">${p.masp }</p> 
					<p id="tensp">${p.tensp }</p> 
					<p id="giasp">$${p.giasp }</p>
					<c:url var="varUpdate" value="UpdateProduct.jsp">
						<c:param name="masp" value="${p.masp }"/>
						<c:param name="tensp" value="${p.tensp }"/>
						<c:param name="giasp" value="${p.giasp }"/>
						<c:param name="hinhsp" value="${p.hinhsp }"/>
						<c:param name="madm" value="${p.madm }"/>
					</c:url>
					<a href="${varUpdate }" id="updatepart">Update Product</a> |
					<c:url var="varDelete" value="ProductServlet">
						<c:param name="masp" value="${p.masp }"/>
						<c:param name="action" value="deletePart"/>
					</c:url>
					<a href="${varDelete }" id="deletepart">Delete</a>
				</div>
				<%
					found = 0;
					count += 1;
				%>
			<%} %>
		</c:forEach>
	</div>
</body>
</html>