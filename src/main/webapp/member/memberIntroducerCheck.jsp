<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천인 확인 | HOSINSA</title>
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
	<div class="intCheck" align="center">
		<h2 class="pop_title">추천인 확인</h2>
		<form action="HosinsaServlet" method="get" name="int_check_frm">
			<input type="hidden" name="command" value="member_introducer_check">
			추천인 <input type="text" name="introducer" value="${introducer}"> <input
				type="submit" value="확인"> <br>
			<c:if test="${result == 1}">
				<script type="text/javascript">
					opener.document.member_join_frm.introducer.value = "";
				</script>
				추천인(${introducer})이 확인되었습니다.
				<input type="button" value="사용" class="cancel"	onclick="intOk('${introducer}')">
			</c:if>
			<c:if test="${result == -1}">
				${introducer}는 존재하지 않는 추천인입니다.
			</c:if>
		</form>
	</div>
</body>
</html>