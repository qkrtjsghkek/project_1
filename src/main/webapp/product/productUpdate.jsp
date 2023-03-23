<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div id="wrap" align="center" class="cart_in_frm">
		<h2>제품 상세보기</h2>
		<form action="HosinsaServlet" name="frm" method="post">
		<input type="hidden" name="command" value="product_info_update">
		<input type="hidden" name="num" value="${product.pronum}">
		<table border="1">
			<tr>
				<td colspan="2" rowspan="6">
					<c:choose>
					<c:when test="${empty product.proimgBig}">
						<img src="hosinsa\images\noimage.gif">
					</c:when>
					<c:otherwise>
						<img src="${product.proimgBig}">
					</c:otherwise>
				</c:choose>
				</td>
				<tr>
				<th>상품명</th>
				<td><input type="text" name="proname" size="30"
						value="${product.proname}"></td>
			</tr>
				<th>카테고리</th>
               <td><select name="category">
                     <option value="상의">상의</option>
                     <option value="아우터">아우터</option>
                     <option value="바지">바지</option>
                     <option value="원피스">원피스</option>
                     <option value="스커트">스커트</option>
                     <option value="신발">신발</option>
               </select></td>
			</tr>

			<tr>
				<th>브랜드</th>
				<td><input type="text" name="brand" size="30"
						value="${product.brand}"></td>
			</tr>

			<tr>
				<th>가격</th>
				<td><input type="text" name="price" size="30"
						value="${product.price}"></td>
			</tr>
			
			<tr>
				<th>재고</th>
				<td><input type="text" name="stock" size="30"
						value="${product.stock}"></td>
			</tr>
		</table>
		<br><br> 
		<input type="submit" value="등록">
		<input type="button" value="취소" onclick="location.href='HosinsaServlet?command=product_view&num=${product.pronum}'">
		</form>
	</div>
</body>
</html>