<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div class="member_list" align="center">
 		<h2> 회원 리스트 </h2>
 		<select id="grade" onchange="grade()">
 			<option selected="selected">등급선택</option>
 			<option value="전체">전체</option>
 			<option value="C">브론즈</option>
 			<option value="B">실버</option>
 			<option value="A">골드</option>
 			<option value="S">운영자</option>
 		</select>
 		<form action="HosinsaServlet" name="id_search_frm" method="post">
 		<input type="hidden" name="command" value="member_id_search">
 			<select name="search_first">
 				<option selected="selected">선택</option>
 				<option>아이디</option>
 				<option>이름</option>
 			</select>
 			<input type="text" name="search_last" placeholder="검색어 입력">
 			<input type="submit" value="검색" onclick="return search_member()">
 		</form>
 		<table class="list">
 			<tr>
 				<th>아이디</th>
 				<th>이름</th>
 				<th>등급</th>
 				<th>포인트</th>
 			</tr>
 			<c:forEach var="member_list" items="${member_list}">
	 			<tr>
	 				<td><a href="HosinsaServlet?command=member_view&id=${member_list.id}">${member_list.id}</a></td>
	 				<td>${member_list.name}</td>
	 				<c:choose>
		 				<c:when test="${member_list.grade eq 'C'}">
		 					<td>LV.1 브론즈</td>
		 				</c:when>
		 				<c:when test="${member_list.grade eq 'B'}">
		 					<td>LV.2 실버</td>
		 				</c:when>
		 				<c:when test="${member_list.grade eq 'A'}">
		 					<td>LV.3 골드</td>
		 				</c:when>
		 				<c:otherwise>
		 					<td>LV.4 운영자</td>
		 				</c:otherwise>
		 			</c:choose>
	 				<td>${member_list.point}</td>
	 			</tr>
	 		</c:forEach>
 		</table>
 		<br><br>
 		<input type="button" value="메인페이지" onclick="location.href='HosinsaServlet?command=main&category'">
 	</div>
</body>
</html>