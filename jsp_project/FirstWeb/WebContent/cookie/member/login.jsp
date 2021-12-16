<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//CookieBox 이용해서 ID를 저장해서 ->  다른 페이지에 이동했을 때 로그인 유무를 판단
	
	// 사용자 요청 정보 : id, pw 를 받아서  쿠키에 저장
	// id/pw 값이 일치할  때 저장
		
	// 데이터 받기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// id/pw 값이 일치할  때 저장 : 로그인 처리
	if(id.equals(pw)){
		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS", -1, "/"));
		//   http://localhost:8080/.....
		response.addCookie(CookieBox.createCookie("ID", id, -1, "/"));
	
		
		String saveID = request.getParameter("saveID");
		
		if(saveID != null && saveID.equals("on")){
			response.addCookie(CookieBox.createCookie("saveID", id, 60*60*24*365, "/"));
		} else {
			response.addCookie(CookieBox.createCookie("saveID", "", 0 , "/"));
		}
		
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 되었습니다.</h1>
	<h3><a href="<%= request.getContextPath() %>/cookie/member/mypage.jsp">mypage</a></h3>
</body>
</html>
<%	} else {%>
<script>
	alert('로그인 실패!!');
	history.go(-1);
</script>
<%	} %>