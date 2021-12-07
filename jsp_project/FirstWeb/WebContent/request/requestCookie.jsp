<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies(); //쿠키객체의 배열이 들어감
		
		//쿠키 데이터의 저장
		//쿠키 이름= 값 -> 쿠키이름을 가져오고 value값을 반환
	
		if(cookies!=null && cookies.length>0){
			for(int i = 0; i < cookies.length; i++){
				Cookie c = cookies[i];
				out.println(c.getName()+"="+ c.getValue());		//쿠키값을 임의로 넣고 수정할수 있으므로 보안이 약해서,
																//많이 저장하지않고 중요하지 않는 데이터들만 저장
			}
		}
	%>
	<hr>
	<h3>host : <%= request.getHeader("host") %>></h3>
	<%
		Enumeration headers =  request.getHeaderNames();
		//Enumeration는 name을 저장한다
		while(headers.hasMoreElements()){			//더 많은 Element요소를 가지고있는지 판단해주는 메소드
			//헤더 이름을 가져온다
			String headerName = (String)headers.nextElement(); //Element반환할떄 object를 반환해줌
			//헤더 이름으로 헤더의 속성 값을 가져온다
			String value = request.getHeader(headerName);
			
			out.println("<h4>"+headerName+" : "+value+"</h4>");
		}
	%>

</body>
</html>