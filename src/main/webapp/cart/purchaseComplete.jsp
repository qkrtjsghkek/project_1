<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문완료 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div class="wrapper">
		<h2>주문이 완료 되었습니다!</h2>
		<br><br><br><h2>주문 목록</h2>
		<table>	
			<c:forEach var="list" items="${list }" varStatus="status">
				<tr>
					<td class="proname"><input type="hidden" name="pronum" value="${list.pronum}">${list.proname}</td>
					<td><input name="quantity" class="quantity" value="${quantity[status.index]}" readonly></td>
				</tr>
			</c:forEach>
		</table>
		<h4 class="rest_pnt">잔여 포인트</h4>
		<p>${point} P<p>
		<input class="bigBtn" type="button" value="메인으로 돌아가기" onclick="location.href='HosinsaServlet?command=main&category'">
	</div>
</body>
</html>