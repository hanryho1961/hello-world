<%@page import="Entities.DanhMuc"%>
<%@page import="Model.DanhMucModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>Welcome Admin: Menu Page</h1>
	<table border="1">
		<tr>
			<th>Madm</th>
			<th>Tendm</th>
			<th>Update Menu</th>
			<th>Delete Menu</th>
		</tr>
		<% ArrayList<DanhMuc> list = new DanhMucModel().getList();%>
		<c:forEach var="dm" items="<%=list %>">
			<tr>
				<td>${dm.madm }</td>
				<td>${dm.tendm }</td>
				<c:url var="varUpdate" value="UpdateMenu.jsp">
					<c:param name="madm" value="${dm.madm }"/>
					<c:param name="tendm" value="${dm.tendm }"/>
				</c:url>
				<td><a href="${varUpdate }">Update</a></td>
				<c:url var="varDelete" value="${request.getContextPath() }/MenuServlet">
					<c:param 
					name="madm" value="${dm.madm }"/>
					<c:param name="tendm" value="${dm.tendm }"/>
					<c:param name="action" value="delete"/>
				</c:url>
				<td><a href="${varDelete }">Delete</a>
			</tr>			
		</c:forEach>
	</table>
	<br>
	<a href="InsertMenu.jsp">Insert</a> |
	<c:url var="varClear" value="${request.getContextPath() }/MenuServlet">
		<c:param name="action" value="clearList"/>
	</c:url>
	<a href="${varClear }">Clear Menu</a>
</body>
</html>