<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
	<div align="center">
		<h2 class="pop_title">비밀번호 확인</h2>
		<form action="HosinsaServlet" name="frm" method="get">
			<input type="hidden" name="command" value="user_pw_check">
			<input type="hidden" name="id" value="${param.id}">
			<table style="width: 80%">
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" size="20"></td>
				</tr>
			</table>
			<br> <input type="submit" value=" 확 인 " onclick="return passCheck()"> <br>
			<br>${message}
		</form>
	</div>
</body>
</html>