<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update: Menu</h1>
	<form action="<%= request.getContextPath() %>/MenuServlet?action=update" method="post">
		<table>
			<tr>
				<td>Madm</td>
				<td><input type="text" value="<%=request.getParameter("madm") %>" name="txtmadm" readonly></td>
			</tr>
			<tr>
				<td>Tendm</td>
				<td><input type="text" value="<%=request.getParameter("tendm") %>" name="txttendm"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>