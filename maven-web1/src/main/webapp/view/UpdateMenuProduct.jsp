<%@page import="Entities.DanhMuc"%>
<%@page import="Model.DanhMucModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update: Product</h1>
	<form enctype="multipart/form-data" action="<%= request.getContextPath() %>/ProductServlet?action=updateMenuProduct&oldmadm=${param.madm }" method="post">
		<table>
			<tr>
				<td>Ma san pham</td>
				<td><input type="text" value="${param.masp }" name="txtmasp" readonly></td>
			</tr>
			<tr>
				<td>Ten san pham</td>
				<td><input type="text" value="${param.tensp }" name="txttensp"></td>
			</tr>
			<tr>
				<td>Gia san pham</td>
				<td><input type="text" value="${param.giasp }" name="txtgia"></td>
			</tr>
			<tr>
				<td>Hinh san pham</td>
				<td><input type="text" id="txt" value="${param.hinhsp }" name="txthinhsp"></td>
				<td><img id="image" src="<%= request.getContextPath() %>/resources/images/${param.hinhsp }" height="100px" width = "70px"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="file" id="chooseimg" name="file">					
					<script type="text/javascript">
						var file = document.getElementById('chooseimg');
						var img = document.getElementById('image');
						var input = document.getElementById('txt');
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
				<td>Danh muc san pham</td>
				<td>
					<% ArrayList<DanhMuc> list = new DanhMucModel().getList(); %>
					<select name="madm">
						<c:forEach var="dm" items="<%=list %>">
							<option value="${dm.madm }" ${dm.madm == param.madm?'selected':'' }>${dm.tendm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>