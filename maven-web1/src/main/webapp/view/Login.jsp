<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="<%= request.getContextPath() %>/AccountServlet" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="txtuser"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="txtpass"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>