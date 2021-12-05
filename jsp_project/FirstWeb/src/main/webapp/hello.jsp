<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.Date"  %>
<%@ page import= "java.time.LocalDateTime"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//java 코드를 작성
	//java.util.Date now1 = new java.util.Date();
	Date now1 = new Date();
	%>
	<%=now1 %>
	<h1><%= LocalDateTime.now() %></h1>
		<h2><%= LocalDateTime.now() %></h2>
		<h3><%= LocalDateTime.now() %></h3>
		<h4><%= LocalDateTime.now() %></h4>
		<h5><%= LocalDateTime.now() %></h5>
	
	

<h1> Hello World</h1>

</body>
</html>