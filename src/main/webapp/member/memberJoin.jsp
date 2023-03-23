<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 | HOSINSA</title>
<link rel="stylesheet" href="css/hosinsa.css">
<script type="text/javascript" src="js/hosinsa.js"></script>
</head>
<body>

<%@ include file="../../header.jsp" %>
	<div class="Join wrapper" align="center">
		<h2>회원가입</h2>
		<form name="member_join_frm" method="post" action="HosinsaServlet">
			<input type="hidden" name="command" value="member_join">
			<input type="hidden" name="grade" value="C">
			<input type="hidden" name="point" value="50000">
			<table class="list">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" size="30" required>
						<input type="hidden" name="reid" size="20">&nbsp;&nbsp;
						<input type="button" value="중복체크" onclick="idCheck()">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pw" size="30" placeholder="숫자, 영문, 특수문자 조합 최소8자" required>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input type="password" name="pw_check" size="30" placeholder="비밀번호를 확인해주세요." required>
					</td>
				</tr>
				<tr>
					<th>이 름</th>
					<td>
						<input type="text" name="name" size="30" placeholder="이름를 입력해 주세요." required>
					</td>
				</tr>
				<tr>
					<th>성 별</th>
					<td class="gender">
						<label><input type="radio" name="gender" value="남자" required>남자</label>
						<label><input type="radio" name="gender" value="여자" required>여자</label>
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
						<input type="date" name="birthday" max="2030-12-31"	min="1950-01-01" required>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
					<input type="text" name="email_id" size="13" required> @ 
						<select name="email_site">
							<option>메일선택</option>
							<c:forTokens var="mail" items="naver.com,nate.com,daum.net,gmail.com,직접입력" delims=",">
								<option>${mail}</option>
							</c:forTokens>						
						</select> &nbsp;
						<input type="text" name="email_write" size="15" placeholder="직접입력란">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<select name="phone_first">
							<option>선택</option>
								<c:forTokens var="phone" items="010,011,012,013,014,060,070,080"
									delims=",">
									<option>${phone}</option>
								</c:forTokens>
						</select>&nbsp;-&nbsp;
						<input type="text" name="phone_center" size="3"	required> &nbsp;-&nbsp;
						<input type="text" name="phone_last" size="3" required>
					</td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="zipcode" size="20" required>&nbsp;&nbsp;
						<input type="button" value="주소검색" onclick="joinGoPopup()">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" size="80" required></td>					
				</tr>
				<tr>
					<th>추천인</th>
					<td>
						<input type="text" name="introducer">
						<input type="hidden" name="reintroducer" size="20"> &nbsp;&nbsp;
						<input type="button" value="추천인 확인" onclick="introducerCheck()">
					</td>
				</tr>
			</table>
			<br><br>
			<input type="submit" value="가입하기" onclick="return joinCheck()">
			<input type="reset" value="다시작성">
			<input type="button" value="돌아가기" onclick="location.href='HosinsaServlet?command=login'">
		</form>
	</div>
</body>
</html>