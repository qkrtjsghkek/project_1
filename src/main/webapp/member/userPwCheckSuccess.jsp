<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호확인 | HOSINSA</title>
</head>
<body>
	<script type="text/javascript">
		if(window.name == "update"){
			window.opener.parent.location.href = "HosinsaServlet?command=user_info_update_form&id=${param.id}";
		}
		window.close();
	</script>
</body>
</html>