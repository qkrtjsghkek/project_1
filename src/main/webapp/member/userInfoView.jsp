<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>

</head>
<body>
<%@ include file="../../header.jsp" %>
	<div class="user_info" align="center">
 		<h2> 내 정보 보기 </h2>
 		<table class="info">
 			<tr>
 				<th>아이디</th>
 				<td>${user_info.id}</td>
 			</tr>
 			<tr>
 				<th>등급</th>
 				<c:choose>
	 				<c:when test="${user_info.grade eq 'C'}">
	 					<td>LV.1 브론즈</td>
	 				</c:when>
	 				<c:when test="${user_info.grade eq 'B'}">
	 					<td>LV.2 실버</td>
	 				</c:when>
	 				<c:when test="${user_info.grade eq 'A'}">
	 					<td>LV.3 골드</td>
	 				</c:when>
	 				<c:otherwise>
	 					<td>LV.4 운영자</td>
	 				</c:otherwise>
	 			</c:choose>
 			</tr>
 			<tr>
 				<th>포인트</th>
 				<td>${user_info.point}</td>
 			</tr>
 			<tr>
 				<th>이름</th>
 				<td>${user_info.name}</td>
 			</tr>
 			<tr>
 				<th>성별</th>
 				<td>${user_info.gender}</td>
 			</tr>
 			<tr>
 				<th>생년월일</th>
 				<td>${user_info.birthday}</td>
 			</tr>
 			<tr>
 				<th>이메일</th>
 				<td>${user_info.email}</td>
 			</tr>
 			<tr>
 				<th>연락처</th>
 				<td>${user_info.phone}</td>
 			</tr>
 			<tr>
 				<th>우편번호</th>
 				<td>${user_info.zipcode}</td>
 			</tr>
 			<tr>
 				<th>집주소</th>
 				<td>${user_info.address}</td>
 			</tr>
 			<tr>
 				<th>추천인</th>
 				<td>${user_info.introducer}</td>
 			</tr>
 		</table><br>
 		<input type="button" value="정보 수정" onclick="open_win('HosinsaServlet?command=user_pw_check_form&id=${user_info.id}', 'update')">
 		&nbsp;&nbsp;
 		<input type="button" value="주문 내역 보기" onclick="location.href='HosinsaServlet?command=order_list'">
 	</div>
</body>
</html>