<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<style>
a{
text-decoration: none;
color: black;

}
a:hover{
text-decoration: underline;
}
#content>div {
	padding: 15px;
}
#content>table {
	border: 0;
	border-collapse: collapse;
	
	width: 900px;
}
#content>table td, #content>table th {
	border: 1px solid #aaa;
	padding: 10px;
	
	text-align: center;
}
#listInfo {
	border : 1px solid #aaa;
	width : 870px;
}
#paging {
	overflow: hidden;
}
#paging>a {
	display: block;
	
	width: 30px;
	height: 30px;
	
	border: 1px solid #aaa;
	
	text-align: center;
	line-height: 30px;
	
	float : left;
	
	margin-right: 5px;
	
	text-decoration: none;
}
#paging>a:hover {
	background-color: #ff0;
	color: #00f;
}
.curpage {
	background-color: #333;
	color: #fff;
}
img{
	height: 30px;
    border: 2px solid #aaa;
    border-radius: 50%;
}
.mright{
margin-right: 20px;
vertical-align: middle;
}
</style>
</head>

<body>

<!-- GuestBookListCommandImpl 클래스가 담아서 전송한 listView 라는 이름의 key 안에 있는
GuestBookListView 객체에서 데이터만 꺼내서 출력해주면 됨
 -->

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3>게시글리스트</h3>
		<hr>
		<div id="listInfo">
			전체 회원 수: ${listView.totalCount}명 , 현재 페이지: ${listView.currentPage}/${listView.pageTotalCount} 
		</div>
		<table>
			<tr>
				
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				
			</tr>
			
			<c:if test="${empty listView.list}">\
			<tr>
				<td colspan="7">등록된 회원 데이터가 없습니다.</td>
			</tr>
			</c:if>
			<c:if test="${not empty listView.list}">
			
			<c:forEach items="${listView.list}" var="gb">
			<tr>
				<td>${gb.idx}</td>
				<td><a href="${pageContext.request.contextPath}/guestbook/content.do?guestbookidx=${gb.idx}">${gb.subject}</a></td>
				<td>${gb.username}</td>
				<td>${gb.regdate}</td>
			</tr>
			</c:forEach>
			
			</c:if>
			
			
		</table>
		<div id="paging">
			<c:if test="${listView.pageTotalCount > 0}">
			
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="pnum">
				<a href="${pageContext.request.contextPath}/guestbook/list.do?pageNum=${pnum}" class="${listView.currentPage eq pnum ? 'curpage': ''}">${pnum}</a>  
			</c:forEach>
			
			</c:if> 	
		</div>
		
		
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

</body>
</html>