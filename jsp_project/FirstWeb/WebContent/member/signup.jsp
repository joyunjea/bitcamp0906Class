<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	아이디 :<%=request.getParameter("userid")%>
	<br> 
	비밀번호 :<%=request.getParameter("pw")%>
	<br> 
	이름 :<%=request.getParameter("username")%>
	<br>
	 자기소개 :<%=request.getParameter("comment")%>
	<br>
	 성별 :<%=request.getParameter("gender")%>
	<br>
	<%	
		String[] interest = request.getParameterValues("interest");
		if(interest == null) {
			out.println("Interest : 관심사가 없습니다.");
		} else {
			for(int i=0; i<interest.length; i++) {
				out.println("관심사 : " + interest[i] );
			}
		}
	%>
	<br>
	생년 : <%= request.getParameter("byear") %>

</body>
</html>