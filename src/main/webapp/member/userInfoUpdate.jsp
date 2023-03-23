<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div id="wrap" align="center">
		<h2>마이페이지</h2>
		<form name="user_info_update_frm" method="post" action="HosinsaServlet">
			<input type="hidden" name="command" value="user_info_update">
			<input type="hidden" name="id" value="${user.id}">
			<table>
				<tr>
					<th>아이디</th>
					<td>${user.id}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" size="20" name="pw" value="${user.pw}"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" size="20" name="pw_check"></td>
				</tr>
				<tr>
	 				<th>등급</th>
	 				<c:choose>
		 				<c:when test="${user.grade eq 'C'}">
		 					<td>LV.1 브론즈</td>
		 				</c:when>
		 				<c:when test="${user.grade eq 'B'}">
		 					<td>LV.2 실버</td>
		 				</c:when>
		 				<c:when test="${user.grade eq 'A'}">
		 					<td>LV.3 골드</td>
		 				</c:when>
		 				<c:otherwise>
		 					<td>LV.4 운영자</td>
		 				</c:otherwise>
		 			</c:choose>
 				</tr>
 				<tr>
	 				<th>포인트</th>
	 				<td>${user.point}</td>
 				</tr>
				<tr>
	 				<th>이름</th>
	 				<td><input type="text" size="20" name="name" value="${user.name}"></td>
	 			</tr>
	 			<tr>
	 				<th>성별</th>
	 				<c:choose>
		 				<c:when test="${user.gender eq '남자'}">
		 					<td>
		 						<input type="radio" name="gender" value="남자" checked>남자
	 							<input type="radio" name="gender" value="여자">여자
	 						</td>
		 				</c:when>
		 				<c:otherwise>
		 					<td>
		 						<input type="radio" name="gender" value="남자">남자
	 							<input type="radio" name="gender" value="여자" checked>여자
	 						</td>
		 				</c:otherwise>
		 			</c:choose>
	 			</tr>
	 			<tr>
	 				<th>생년월일</th>
	 				<td>			
						<input type="date" name="birthday" max="2030-12-31" min="1950-01-01" value="${user.birthday}">
					</td>
	 			</tr>
	 			<tr>
	 				<th>이메일</th>
	 				<td><input type="email" size="20" name="email" value="${user.email}"></td>
	 			</tr>
	 			<tr>
	 				<th>연락처</th>
	 				<td><input type="text" size="20" name="phone" value="${user.phone}"></td>
	 			</tr>
	 			<tr>
	 				<th>우편번호</th>
	 				<td>
	 					<input type="text" size="10" name="zipcode" value="${user.zipcode}">&nbsp;&nbsp;
	 					<button type="button" onclick="userGoPopup()">주소검색</button>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>집주소</th>
	 				<td><input type="text" size="80" name="address" value="${user.address}"></td>
	 			</tr>
	 			<tr>
	 				<th>추천인</th>
	 				<td><input type="text" size="20" name="introducer" value="${user.introducer}"></td>
	 			</tr>
			</table>
			<br><br>
			<input type="submit" value="등록" onclick="return updateCheck()">
			<input type="reset" value="다시 작성">
		</form>
	</div>
</body>
</html>