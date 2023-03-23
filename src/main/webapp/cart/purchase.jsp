<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록 | HOSINSA</title>
<script type="text/javascript" src="js/hosinsa.js"></script>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>

<%@ include file="../../header.jsp" %>
<div class="wrapper">
	<h2>주문목록</h2>
	<form name="frm" action="HosinsaServlet" method="post">
		<input type="hidden" name="command" value="purchase_complete">
		<input type="hidden" name="id" value="${loginUser.id}">
		<%
		//주문 중복요청 방지를 위해 유효 flag를 만들어 세션에 태워 보냄.(CartPurchaseCompleteAction으로 연계)
		   boolean flag = true;		
		   session.setAttribute("flag", flag);		
		%>
		<table border="1">
			<colgroup>
				<col width="200px"/>
				<col width="*"   />
			</colgroup>
			<c:forEach var="list" items="${list }" varStatus="status">
				<tr>
					<td class="proname"><input type="hidden" name="pronum" value="${list.pronum}">${list.proname}</td>
					<td><input name="stock" class="stock hidden" value="${list.stock}"><input name="quantity" class="quantity" value="${quantity[status.index]}" readonly></td>
				</tr>
			</c:forEach>
			<tr>
				<th>결 제 금 액</th>
				<td><input id="total_cash" name="total_cash" value="${param.total}" readonly> 원</td>
			</tr>
			<tr>
				<th>사용 가능 포인트</th>
				<td><input type="number" id="av_pnt" name="av_pnt" value="<%=request.getAttribute("point") %>" readonly>P </td>
			</tr>	    
			<tr>
				<th>포인트 사용</th>
				<td>
					<span><input type="number" name="use_pnt" id="use_pnt" max="${param.total}" min="0"></span>P
				</td>
			</tr>
			<tr>
				<th>최종 결제 금액</th>
				<td> <p><span id="result_pnt"></span> 원</p> </td>
			</tr>			
		</table>
		<div class="input_wrap">
			<input type="submit" value="결제하기" onclick="return pointCheck()">
			<input type="button" value="취소" onclick="location.href='HosinsaServlet?command=main&category='">
		</div>		
	</form>
</div>
</body>
</html>