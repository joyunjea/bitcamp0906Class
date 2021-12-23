<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/guestbook/write.do" method="post">
		<input type="text" name="subject" placeholder="제목"> 
		<input type="text" name="content" placeholder="내용">
		<input type="hidden"name="memberidx" value="${sessionScope.loginInfo.idx}"> 
		<input type="submit" value="등록">
	</form>
</body>
</html>