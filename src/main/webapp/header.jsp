<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 호신사 스토어 </title>
</head>
<body>
	
	<header>
		<div class="header_menu">
			<h1>
				<a class="logo" href="HosinsaServlet?command=main&category">HOSINSA</a>
			</h1>
			<ul>
				<li class="user_grade">
					<c:choose>
						<c:when test="${empty loginUser}">
							<input type="button" value="로그인" class="btn_login" onclick="location.href='HosinsaServlet?command=login'">
						</c:when>
						<c:otherwise>
							<c:choose>
				 				<c:when test="${loginUser.grade eq 'C'}">
				 					LV.1 브론즈 &nbsp;${loginUser.name}님
				 				</c:when>
				 				<c:when test="${loginUser.grade eq 'B'}">
				 					LV.2 실버 &nbsp;${loginUser.name}님
				 				</c:when>
				 				<c:when test="${loginUser.grade eq 'A'}">
				 					LV.3 골드 &nbsp;${loginUser.name}님
				 				</c:when>
				 				<c:otherwise>
				 					LV.4 운영자 &nbsp;${loginUser.name}님
				 				</c:otherwise>
		 					</c:choose>
		 				</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${empty loginUser}">
							<a href="HosinsaServlet?command=login"><span>마이페이지</span></a>
						</c:when>
						<c:otherwise>
							<a href="HosinsaServlet?command=user_info_view&id=${loginUser.id}"><span>마이페이지</span></a>
						</c:otherwise>
					</c:choose>
				</li>
				<c:if test="${not empty loginUser}">
					<li><a href="HosinsaServlet?command=cart_list&id=${loginUser.id}"><span>카트</span></a></li>
				</c:if>
				<c:if test="${loginUser.grade eq 'S'}">
					<li><a href="HosinsaServlet?command=product_list&category"><span>상품관리</span></a></li>
					<li><a href="HosinsaServlet?command=member_list&grade"><span>회원관리</span></a></li>
				</c:if>
				<c:if test="${not empty loginUser}">
					<li><a href="HosinsaServlet?command=logout"><span>로그아웃</span></a></li>
				</c:if>
			</ul>
		</div>
	</header>
</body>
</html>