<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>
<%@ include file="../../header.jsp" %>
<div id="wrap" align="center" class="order_info">
	<h2>주문 내역</h2>
	<c:if test="${empty list }">
		<h3 class="order_empty">주문 내역이 없습니다.</h3>
	</c:if>
	<c:if test="${not empty list}"> 
		<c:forEach var="list" items="${list }">
			<table>
				<tr>
					<th>주문번호</th>
					<td>${list.ordernum}</td>
				</tr>
				<tr>
					<th>주문날짜</th>
					<td>${list.orderdate}</td>
				</tr>
				<tr>
					<th>결제금액</th>
					<td>${list.price}</td>
				</tr>									
			</table>
		</c:forEach>
	</c:if>
	
	<input type="button" value="돌아가기" onclick="javascript:history.go(-1);">
</div>
</body>
</html>