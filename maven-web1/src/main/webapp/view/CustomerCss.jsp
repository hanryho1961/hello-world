<%@page import="Model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CustomerPage: Product</title>
	<style>
		div#container {
			box-shadow: 0 0 0 5px black, 0 0 0 7px red;
			border-spacing: 10px;
			width: 920px;
			height: 800px;
			margin: 0px auto;
		}
		p#name {
			font-size: 200%;
			font-weight: bold;
			text-align: center;
			/* border: 1px red solid; */
		}
		div#col1 {
			width: 170px;
			height: 180px;
			border: 1px black double;
			border-radius: 5px;
			margin-left: 10px;
			margin-top: 10px;
			margin-right: 10px;
			margin-bottom: 10px;
			float: left;
		}
		div#col2 {
			width: 170px;
			height: 180px;
			border: 1px black double;
			border-radius: 5px;
			margin-top: 10px;
			margin-bottom: 10px;
			float: left;
		}
		div#col3 {
			width: 920px;
			height: 60px;
			/* border: 1px red solid; */
			margin-top: 700px;
		}
		img#image1 {
			display: block;
			margin-top: 5px;
   			margin-left: auto;
    		margin-right: auto;
    		width: 50%;
    		/* border: 1px black solid; */
		}
		img#image2 {
			display: block;
			margin-top: 5px;
   			margin-left: auto;
    		margin-right: auto;
    		width: 50%;
    		/* border: 1px black solid; */
		}
		p#masp {
			font-size: 11px;
			text-align: center;
		}
		p#tensp {
			font-size: 11px;
			text-align: center;
		}
		p#giasp {
			font-size: 11px;
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
					<img src="<%= request.getContextPath() %>/resources/images/${p.hinhsp }" height="70px" width="62px" id="image1">
					<p id="masp">${p.masp }</p> 
					<p id="tensp">${p.tensp }</p> 
					<p id="giasp">$${p.giasp }</p>
					<a href="<%= request.getContextPath() %>/CartServlet?action=add&masp=${p.masp }" id="addtocart">Add to Cart</a> 
				</div>
				<%
					found = 1; 
					count += 1;
				%>
			<%} else if (found == 1) {%>
				<div id="col2">
					<img src="<%= request.getContextPath() %>/resources/images/${p.hinhsp }" height="70px" width="62px" id="image2">
					<p id="masp">${p.masp }</p> 
					<p id="tensp">${p.tensp }</p> 
					<p id="giasp">$${p.giasp }</p>
					<a href="<%= request.getContextPath() %>/CartServlet?action=add&masp=${p.masp }" id="addtocart">Add to Cart</a> 
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