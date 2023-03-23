<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div class="login_frm">
		<form class="frm1" name="frm1" method="post" action="HosinsaServlet">
			<input type="hidden" name="command" value="user_check">
			<fieldset>
				<legend>호신사에 오신 것을 환영합니다.</legend>
				<label for="userid">아이디</label>
				<input type="text" class="info" id="id" name="id" value="${id}" placeholder="아이디를 입력하세요"><br>
				<label for="userpw">비밀번호</label>
				<input type="password" class="info" id="pw" name="pw" value="${pw}" placeholder="비밀번호를 입력하세요"><br>
				<div class="btn1">
					<input type="submit" name="login" value="로그인" onclick="return loginCheck()">
					<input type="reset" value="취소">
					<input type="button" name="signup" value="회원가입" onclick="location.href='HosinsaServlet?command=member_join_form'">
				</div>
				<br><br><br><br>
				${message}
			</fieldset>
		</form>
	</div>
</body>
</html>