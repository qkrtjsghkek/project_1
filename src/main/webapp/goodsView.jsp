<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
<script>
  WebFont.load({
    google: {
      families: ['Kaushan Script', cursive]
    }
  });
</script>
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
	<form name="cart_in_frm" method="post" action="HosinsaServlet" class="cart_in_frm">
		<input type="hidden" name="command" value="cart_in">
		<input type="hidden" name="id" value="${loginUser.id}">
		<input type="hidden" name="pronum" value="${goodsView.pronum}">
		<div id="wrap" align="center">
		<h2>제품 상세보기</h2>
			<table border="1">
				<tr>
					<td colspan="2" rowspan="3">
						<c:choose>
							<c:when test="${empty goodsView.proimgBig}">
								<img src="hosinsa\images\noimage.gif">
							</c:when>
							<c:otherwise>
								<img src="${goodsView.proimgBig}">
							</c:otherwise>
						</c:choose>
					</td>
					<th> 카테고리 </th> <td> ${goodsView.category} </td>
				</tr>
				<tr>
					<th> 브랜드 </th> <td>${goodsView.brand}</td>
				</tr>
				
				<tr>
					<th> 가격 </th> <td> ${goodsView.price} </td>
				</tr>
				<tr>
					<th > 이름 </th> <td> ${goodsView.proname} </td>
					<th > 재고 </th> <td> ${goodsView.stock} </td>
				</tr>			
			</table>
		</div>
		<div class="inputWrap">
	<input type="number" name="quantity" min="1" value="1">
	<input type="submit" value="Add to Cart" onclick="return userCheck()">
	<input type="button" value="뒤로" onclick="location.href='HosinsaServlet?command=main&category'">
		</div>
	</form>
	<br><br>
</body>
</html>