<%@page import="java.util.ArrayList"%>
<%@page import="Model.DanhMucModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>Insert: Product</h1>
	<form enctype="multipart/form-data" action="<%= request.getContextPath() %>/ProductServlet?action=insert" method="post">
		<table>
			<tr>
				<td>Masp</td>
				<td><input type="text" name="txtmasp" id="txtmasp"></td>
				<td><p id="warning"></p></td>
			</tr>
			<tr>
				<td>Tensp</td>
				<td><input type="text" name="txttensp"></td>
			</tr>
			<tr>
				<td>Giasp</td>
				<td><input type="text" name="txtgia"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<img id="image" height="100px" width="80px"/>
				</td>
			</tr>
			<tr>
				<td>Hinhsp</td>
				<td>
					<input type="file" id="chooseimg" name="file">
					<script type="text/javascript">
						var file = document.getElementById('chooseimg');
						var img = document.getElementById('image');
						file.addEventListener("change", function() {
							if (this.value) {
								var file = this.files[0];
								var reader = new FileReader();
								reader.onloadend = function () {
									img.src = reader.result;
								};
								reader.readAsDataURL(file);
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<td>dmsp</td>
				<% ArrayList list = new DanhMucModel().getList(); %>
				<td>
					<select name="madm">
						<c:forEach var="dm" items="<%=list %>">
							<option value=${dm.madm }>${dm.tendm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#txtmasp").keyup(function() {
				var masp = $("#txtmasp").val();
				$.ajax({
					type: "post",
					data: {
						masp: masp,
						action: "insertProduct"
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