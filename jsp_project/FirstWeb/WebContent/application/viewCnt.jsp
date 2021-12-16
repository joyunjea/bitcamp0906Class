<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// application 객체의 속성 값을 가져온다!
	String strcnt = (String)application.getAttribute("cnt");
	//(논리값) ? 참일 때 값 : 거짓일 때 값
	int cnt = (strcnt == null) ? 0 : Integer.parseInt(strcnt);
	
	/* 
	int cnt = 3;
	
	int num=0;
	if(strcnt == null){
		num = 0;
	} else {
		num = Integer.parseInt(strcnt);
	} 
	*/
	
	
	
	// application 객체의 속성 값 저장!
	application.setAttribute("cnt", String.valueOf(++cnt));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방문자 수 <%= cnt %></h1>
</body>
</html>