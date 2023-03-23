<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div class="member_list" align="center">
 		<h2> 회원 리스트 </h2>
 		<form name="frm" method="post" action="HosinsaServlet">
 			<input type="hidden" name="command" value="member_manage">
	 		<table class="list">
	 			<tr>
	 				<th>아이디</th>
	 				<td><input type="text" name="id" value="${member.id}" readonly></td>
	 			</tr>
	 			<tr>
	 				<th>이름</th>
	 				<td><input type="text" name="name" value="${member.name}" readonly></td>
	 			</tr>
	 			<tr>
	 				<th>등급</th>
	 				<td>
		 				<c:choose>
			 				<c:when test="${member.grade eq 'C'}">
			 					<input type="radio" name="grade" value="C" checked="checked">LV.1 브론즈
			 					<input type="radio" name="grade" value="B">LV.2 실버
			 					<input type="radio" name="grade" value="A">LV.3 골드
								<input type="radio" name="grade" value="S">LV.4 운영자
			 				</c:when>
			 				<c:when test="${member.grade eq 'B'}">
								<input type="radio" name="grade" value="C">LV.1 브론즈
								<input type="radio" name="grade" value="B" checked="checked">LV.2 실버
			 					<input type="radio" name="grade" value="A">LV.3 골드
			 					<input type="radio" name="grade" value="S">LV.4 운영자
			 				</c:when>
			 				<c:when test="${member.grade eq 'A'}">
								<input type="radio" name="grade" value="C">LV.1 브론즈
								<input type="radio" name="grade" value="B">LV.2 실버
			 					<input type="radio" name="grade" value="A" checked="checked">LV.3 골드
			 					<input type="radio" name="grade" value="S">LV.4 운영자
			 				</c:when>
			 				<c:otherwise>
			 					<input type="radio" name="grade" value="C">LV.1 뉴비
								<input type="radio" name="grade" value="B">LV.2 멤버
			 					<input type="radio" name="grade" value="A">LV.3 골드
			 					<input type="radio" name="grade" value="S" checked="checked">LV.4 운영자
			 				</c:otherwise>
			 			</c:choose>
			 		</td>
	 			</tr>
	 			<tr>
	 				<th>포인트</th>
	 				<td><input type="text" size="12" name="point" value="${member.point}"></td>
	 			</tr>
	 		</table>
			<br><br>
			<input class="button" type="submit" value="수정 완료">
			<input class="button" type="reset" value="다시 작성">
			<input class="button" type="button" value="목록" onclick="location.href='HosinsaServlet?command=member_list'">
	 	</form>
 	</div> 	
</body>
</html>