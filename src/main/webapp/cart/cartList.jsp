<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>
<%@ include file="../../header.jsp" %>
	<form class="cartForm">
		<h2>Cart</h2>
		<input type="hidden" name="command" value="purchase" id="cammand">
		<table>
			<c:if test="${empty list}">
				<h3 class="cart_empty">장바구니에 담긴 상품이 없습니다.</h3>
			</c:if>
			<c:if test="${not empty list}"> 
				<c:forEach var="list" items="${list }" varStatus="status">
					<tr>
						<td>
							<c:choose>
								<c:when test="${empty list.proimgSmall}">
									<img class="cart_img" src="hosinsa\images\noimage.gif">
								</c:when>
								<c:otherwise>
									<img class="cart_img" src="${list.proimgSmall}">
								</c:otherwise>
							</c:choose>
						</td>
						
						<td><input type="hidden" name="pronum" value="${list.pronum }">${list.proname }</td><td>${list.price }</td>						
				 		<td>수량 <input type="number" name="quantity" min=1 value="${list2[status.index].quantity}">
				 		<input type="button" value="수정" class="modify" onclick="location.href='HosinsaServlet?command=modify_quantity&cartnum=${list2[status.index].cartnum}&id=${list2[status.index].id}"></td>
						<td>${list.price*list2[status.index].quantity}</td>
						<td><input type="button" value="삭제" onclick="location.href='HosinsaServlet?command=delete_item&cartnum=${list2[status.index].cartnum}&id=${list2[status.index].id}'"></td>
					</tr>
					<c:set var="sum" value="${sum + (list.price * list2[status.index].quantity)}" />
					<c:set var="id" value="${list2[status.index].id}"/>
				</c:forEach>
					<tr><td colspan="6">배송비 : <c:if test="${sum < 50000 }"><span>3000</span> 원</c:if> (5만원 이상 무료배송!!)</td></tr>
			<c:if test="${sum < 50000 }">
			<c:set var="sum" value="${sum+3000 }"/>
			</c:if>
				<tr><td colspan="6">총액 : <input type="text" name="total" value="${sum }" class="total" readonly> 원</td></tr>
				<tr><td colspan="6"><input type="submit" value="구매하기" id="purchase"> <input type="button" value="장바구니 비우기" onclick="location.href='HosinsaServlet?command=reset_cart&id=${id}'"/></td>
			</c:if>
		</table>
	</form>
	<script>
		document.querySelectorAll("input[name=quantity]").forEach(function(item){
			item.addEventListener('change',function(){
				this.setAttribute('value',this.value);
				
				
			})
		});
		document.querySelectorAll(".modify").forEach(function(item){
			item.addEventListener('click',function(){
				const value="&value="+this.previousElementSibling.value;
				console.log(value);
				let onclick=this.getAttribute("onclick")+value+"'";
				this.setAttribute("onclick",onclick);
				this.click();
			})
		});
	</script>
</body>
</html>