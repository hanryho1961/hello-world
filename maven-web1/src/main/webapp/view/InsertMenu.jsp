<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script
		src="https://code.jquery.com/jquery-3.2.1.js"
		integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
		crossorigin="anonymous">
	</script>
</head>
<body>
	<h1>Insert: Menu</h1>
	<form action="<%= request.getContextPath() %>/MenuServlet?action=insert" method="post">
		<table>
			<tr>
				<td>Madm</td>
				<td><input type="text" name="txtmadm" id="txtmadm"></td>
				<td><p id="warning"></p></td>
			</tr>
			<tr>
				<td>Tendm</td>
				<td><input type="text" name="txttendm"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#txtmadm").keyup(function() {
				var madm = $("#txtmadm").val();
				$.ajax({
					type: "post",
					data: {
						madm: madm,
						action: "insertMenu"
					},
					url:'AjaxServlet',
					success:function(result) {
						$("#warning").html(result);
					}
				});
			});
		});
	</script>
	
</body>
</html>