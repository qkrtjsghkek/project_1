<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> HOSINSA </title>
<link rel="preload" href="https://fonts.googleapis.com">
<link rel="preload" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
<style>
@import url('https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Noto+Sans+KR:wght@500&display=swap');
</style>
<link rel="stylesheet" href="css/hosinsa.css">
</head>
<body>
<%@ include file="../../header.jsp" %>
    <div class="nav_menu">
        <ul>
            <li>
                <input type="button" name="category" value="인기" onclick="location.href='HosinsaServlet?command=main&category=인기'">
            </li>
            <li>
                <input type="button" name="category" value="상의" onclick="location.href='HosinsaServlet?command=main&category=상의'">
            </li>
            <li>
               <input type="button" name="category" value="아우터" onclick="location.href='HosinsaServlet?command=main&category=아우터'">
            </li>
            <li>
                <input type="button" name="category" value="바지" onclick="location.href='HosinsaServlet?command=main&category=바지'">
            </li>
            <li>
                <input type="button" name="category" value="원피스" onclick="location.href='HosinsaServlet?command=main&category=원피스'">
            </li>
            <li>
                <input type="button" name="category" value="스커트" onclick="location.href='HosinsaServlet?command=main&category=스커트'">
            </li>
            <li>
                <input type="button" name="category" value="신발" onclick="location.href='HosinsaServlet?command=main&category=신발'">
            </li>
        </ul>
    </div>
	<section>
		<c:forEach var="productView_list" items="${productView_list}">
 			<div class="list_box" onclick="location.href='HosinsaServlet?command=goods_view&pronum=${productView_list.pronum}'">
				<div class="list_img">
					<img src="${productView_list.proimgSmall}">
				</div>
				<div class="article_info">
					<p class="pbrand">${productView_list.brand}</p>
					<p class="pname">${productView_list.proname}</p>
					<p class="price">${productView_list.price}</p>
					<p class="view">view ${productView_list.proview}</p>
				</div>
			</div>
	 	</c:forEach>
	</section>

</body>
</html>