<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
	<div class="idCheck" align="center">
		<h2>아이디 중복확인</h2>
		<form action="HosinsaServlet" method="get" name="id_check_frm">
		<input type="hidden" name="command" value="member_id_check">
			아이디 <input type="text" name="id" value="${id}">
				<input type="submit" value="중복체크">
			<br>
			<c:if test="${result == 1}">
				<script type="text/javascript">
					opener.document.join_frm.id.value = "";
				</script>
				${id}는 이미 사용 중인 아이디입니다.
			</c:if>
			<c:if test="${result == -1}">
				${id}는 사용 가능한 아이디입니다.
				<input type="button" value="사용" class="cancel" onclick="idok('${id}')">
			</c:if>
		</form>
	</div>
</body>