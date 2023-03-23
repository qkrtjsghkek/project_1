<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품번호 중복 확인 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
	<div class="idCheck" align="center">
		<h2>제품번호 중복확인</h2>
		<form action="HosinsaServlet" method="get" name="pronum_check_frm">
		<input type="hidden" name="command" value="product_pronum_check">
			제품번호 <input type="text" name="pronum" value="${pronum}">
				<input type="submit" value="중복체크">
			<br>
			<c:if test="${result == 1}">
				<script type="text/javascript">
					opener.document.frm3.pronum.value = "";
				</script>
				${pronum}는 이미 사용 중인 제품번호입니다.
			</c:if>
			<c:if test="${result == -1}">
				${pronum}는 사용 가능한 제품번호입니다.
				<input type="button" value="사용" class="cancel" onclick="numok('${pronum}')">
			</c:if>
		</form>
	</div>
</body>