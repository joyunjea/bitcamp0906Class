<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
$(document).ready(function(){
	$('#myForm input[type=button]').on('click',function(){
		// 등록 버튼을 클릭시 아래 코드를 실행
		
		// 비동기 통신 ( 페이지를 이동하지 않고 결과를 이 페이지에서 받아서 분기함 )
		$.ajax({
			url:'${pageContext.request.contextPath}/guestbook/writeAjax.do',
			type:'POST',
			// data : 파라미터로 보낼 테이터
			// id 가 myForm 인 요소 밑에 있는 모든 입력값을 파라미터로 자동 변환 하여 서버로 전송
			data:$('#myForm').serialize(),
			// 제목에 입력한 내용, 회원의 인덱스, 내용에 입력한 내용을 파라미터로 자동 변환
			
			// success : 통신에 성공시 function(data){코드} 실행
			// data는 GuestBookWriteAjaxCommandImpl 이 반환한 경로에 있는 결과 데이터 (writeAjax.jsp 참고)
			
			success:function(data){
				// data 값이 1이면 (정상 등록되었다면)
				if(data==1){
					// 메세지 띄우고
					alert('등록완료!');
					// 게시글 리스트 보는 화면으로 이동
					location.href="${pageContext.request.contextPath}/guestbook/list.do";
				}else{
					// 등록실패시
					// 경고창 띄우고 추가 처리 x
					// 즉 작성 후에 등록버튼을 눌렀을 때에 얘기치 못한 예외발생으로 인해 등록이 되지 않더라도,
					// 작성했던 내용을 유지할 수 있다 (경고창만 띄우고  location.href 코드를 사용하여 어디로 보내지 않기 때문에)
					alert('등록실패!');
				}
			}
			
			
		})
		
		
	})
	
	
})

</script>
<title>글 쓰기</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/guestbook/write.do" method="post" id="myForm">
		<input type="text" name="subject" placeholder="제목"> 
		<input type="text" name="content" placeholder="내용">
		<input type="hidden"name="memberidx" value="${sessionScope.loginInfo.idx}"> 
		<input type=button value="등록">
	</form>
</body>
</html>