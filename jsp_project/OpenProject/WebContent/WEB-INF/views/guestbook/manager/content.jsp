<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<style>
#content table td {
	padding: 5px;
}
#content>table tr>td:nth-child(1) { 
	width: 100px;
	text-align: center;
	background-color: #ddd;
	
}
#content>table td>img {
	height : 25px;
	border: 1px solid #aaa;
	border-radius: 50%;
	
	vertical-align: middle;
}
#content>table {
	border: 0;
	border-collapse: collapse;
	
	width: 900px;
}
#content>table td {
	padding: 10px;
	
}
#content>table tr {
	border-top: 1px solid #aaa;
	border-bottom: 1px solid #aaa;
}
#replyArea {
	width : 600px;
	margin-top : 20px;
}
div.reply {
	border : 1px solid #aaa;
	overflow: hidden; 
	
	padding: 15px;
	margin-top : 5px;
}
div.reply>div.img {
	width : 50px;
	float : left;
}
div.reply>div.img>img {
	width : 40px;
	height : 40px;
	
	border : 1px solid #aaa;
	
	border-radius: 50%;
}
div.reply>div.content {
	width : 480 px;
	float : left;
}
div.reply>div.close {
	width : 30px;
	float : right;
}
div.reply>div.close>div {
	width : 25px;
	height : 25px;
	
	text-align: center;
	line-height: 20px;
	
	background-color: #aaa;
}
#replyWrite {
	width : 600px;
	
	margin-top : 20px; 
}
#replyWrite>h4 {
	margin: 5px 0;
}
#replyWrite textarea {
	width : 100%;
	font-size : 120%;
	padding : 5px;
}
#replyWrite>form {
	text-align: right;
}
</style>
</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3>방명록 보기</h3>
		<hr>
		<table>
			<tr>
				<td>작성자</td>
				<td>${contentInfo.username} </td>
			</tr>			
			<tr>
				<td>작성일</td>
				<td>${contentInfo.regdate} </td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${contentInfo.subject} </td>
			</tr>
			<tr>
				<td>내용</td>
				<td >
					<pre style="line-height: 180%">${contentInfo.content}</pre>
				</td>
			</tr>
		</table>
		
		<div id="replyArea">
		
			<h3>댓글</h3>
			<hr>
		
			<div id="replyList">
			
				<div id="reply11" class="reply">
					<div class="img">
						<img src="/op/uploadfile/mini.jpg">
					</div>
					<div class="content">
						<h4>손흥민</h4>
						<div>
							<pre>안녕하세요</pre>
						</div>
					</div>	
					<div class="close">
						<div onclick="alert('삭제합니다.');">X</div>
					</div>						
				</div>
				
				<div id="reply12" class="reply">
					<div class="img">
						<img src="/op/uploadfile/mini.jpg">
					</div>
					<div class="content">
						<h4>손흥민</h4>
						<div>
							<pre>안녕하세요</pre>
						</div>
					</div>	
					<div class="close">
						<div onclick="alert('삭제합니다.');">X</div>
					</div>						
				</div>
			
			</div>
			
			<div id="replyWrite">
			
				<h4>${loginInfo.userName}</h4>
				
				<form id="replyWriteForm">
				<!-- http://localhost:8080/op/guestbook/reply.do -->
				
				<textarea name="message" rows="5" cols="30"></textarea>
				<input type="hidden" name="memberidx" value="${loginInfo.idx}">
				<input type="hidden" name="guestbookidx" value="${contentInfo.idx}">
				<br>
				<input type="submit" value="작성">
				</form>
			
			</div>
		</div>
		
		<div class="viewpagemenu">
			<a href="">목록</a> 
			<c:if test="${loginInfo.idx eq contentInfo.memberidx}">
			<a href="">수정</a> 
			<a href="">삭제</a>
			</c:if>
		</div>

	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>
	
	
<script>
	
	$(document).ready(function(){
		
		$('#replyWriteForm').submit(function(){
			
			$.ajax({
				url : 'reply/write.do',
				type : 'POST',
				data : $(this).serialize(),
				success : function(data){
					if(data==1){
						console.log(data);
						alert('등록 성공');
						//location.href="${pageContext.request.contextPath}/guestbook/content.do?guestbookidx=${contentInfo.idx}";
						//1. 화면에 출력할 html 응답
						//2. 화면에 출력할 데이터 JSON 받고 파싱
					}else{
						alert('등록실패!');
					}
					
				},
				error : function(){
					console.log('통신에러 !!!!!');
				}
			});
			
			
			
			return false;
		});
		
	});
</script>
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>