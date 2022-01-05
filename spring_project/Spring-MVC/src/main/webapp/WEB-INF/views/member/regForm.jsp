<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 폼</h1>
	<hr>
	<form action="reg" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" value="${reg.uid}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" value="${reg.pw}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="uname" value="${reg.uname}"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="photo"></td>
			</tr>
			<tr>

				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>