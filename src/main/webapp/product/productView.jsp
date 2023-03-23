<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품보기 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div id="wrap" align="center" class="cart_in_frm">
		<h2>제품 상세보기</h2>
		<table border="1" class="product_table">
			<tr>
				<td colspan="2" rowspan="6"><c:choose>
						<c:when test="${empty product.proimgBig}">
							<img src="product\images\noimage.gif">
						</c:when>
						<c:otherwise>
							<img src="${product.proimgBig}">
						</c:otherwise>
					</c:choose></td>
			<tr>
				<th>상품명</th>
				<td>${product.proname}</td>
			</tr>

			<tr>
				<th>카테고리</th>
				<td>${product.category}</td>
			</tr>

			<tr>
				<th>브랜드</th>
				<td>${product.brand}</td>
			</tr>

			<tr>
				<th>가격</th>
				<td>${product.price}</td>
			</tr>

			<tr>
				<th>재고</th>
				<td>${product.stock}</td>
			</tr>
		</table>
		<br><br>
		<input type="button" value="제품 수정" onclick="location.href='HosinsaServlet?command=product_update&num=${product.pronum}'">
		<input type="button" value="제품 삭제" onclick="location.href='HosinsaServlet?command=product_delete&num=${product.pronum}'">
		<input type="button" value="취소" onclick="location.href='HosinsaServlet?command=product_list&category='">
	</div>
</body>
</html>