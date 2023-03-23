<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div class="member_list" align="center">
 		<h2> 회원 리스트 </h2>
 		<form name="frm" method="post">
			<table class="list">
	 			<tr>
	 				<th>아이디</th>
	 				<td>${member.id}</td>
	 			</tr>
	 			<tr>
	 				<th>이름</th>
	 				<td>${member.name}</td>
	 			</tr>
	 			<tr>
	 				<th>등급</th>
		 			<c:choose>
		 				<c:when test="${member.grade eq 'C'}">
		 					<td>LV.1 브론즈</td>
		 				</c:when>
		 				<c:when test="${member.grade eq 'B'}">
		 					<td>LV.2 실버</td>
		 				</c:when>
		 				<c:when test="${member.grade eq 'A'}">
		 					<td>LV.3 골드</td>
		 				</c:when>
		 				<c:otherwise>
		 					<td>LV.4 운영자</td>
		 				</c:otherwise>
		 			</c:choose>
	 			</tr>
	 			<tr>
	 				<th>포인트</th>
	 				<td>${member.point}</td>
	 			</tr>
	 		</table>
			<br><br>
			<input class="button" type="button" value="회원 정보 수정" onclick="location.href='HosinsaServlet?command=member_manage_form&id=${member.id}'">
			&nbsp;&nbsp;
			<input class="button" type="button" value="목록" onclick="location.href='HosinsaServlet?command=member_list&grade'">
	 	</form>
 	</div> 	
</body>
</html>