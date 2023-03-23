<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보 수정 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
	<div class="product_list" align="center">
		<h2>상품 리스트</h2>
			<select id="category" onchange="category()">
				<option selected="selected">카테고리선택</option>
				<option value="전체">전체</option>
				<option value="아우터">아우터</option>
				<option value="상의">상의</option>
				<option value="바지">바지</option>
				<option value="원피스">원피스</option>
				<option value="스커트">스커트</option>
				<option value="신발">신발</option>
			</select>
			<div class="search">
			<form action="HosinsaServlet" name="search_frm" method="post">
			<input type="hidden" name="command" value="product_category_search">
				<select name="search_first">
					<option selected="selected">선택</option>
					<option>제품번호</option>
					<option>제품이름</option>
					<option>브랜드</option>
				</select> 
				<input type="text" name="search_last" placeholder="검색어 입력"> 
				<input type="submit" value="검색" onclick="return search()">
			</form>
		</div>
		<form name="frm" method="post">
			<table class="list">
				<tr>
					<th>카테고리</th>
					<th>제품번호</th>
					<th>상품명</th>
					<th>브랜드</th>
					<th>가격</th>
					<th>재고</th>
				</tr>
				<c:forEach var="product_list" items="${product_list}">
		 			<tr>
		 				<td>${product_list.category}</td>
		 				<td>${product_list.pronum}</td>
		 				<td><a href="HosinsaServlet?command=product_view&num=${product_list.pronum}">${product_list.proname}</a></td>
		 				<td>${product_list.brand}</td>
		 				<td>${product_list.price}</td>
		 				<td>${product_list.stock}</td>
		 			</tr>
	 			</c:forEach>	 		
			</table>
			<br><br>
            <input type="button" value="상품 등록" onclick="location.href='HosinsaServlet?command=product_write_form'">
            <input type="button" value="돌아가기" onclick="location.href='HosinsaServlet?command=main&category'">
		</form>
	</div>
</body>
</html>