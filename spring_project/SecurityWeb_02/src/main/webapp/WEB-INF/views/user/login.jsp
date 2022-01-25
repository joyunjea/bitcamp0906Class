<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <p>ID : <input type="text" id="email" name="username"></p>
    <p>PASSWORD : <input type="password" id="password" name="password"></p>
    <button id="joinBtn" onclick="login()">Login</button>
</body>
<script src="//code.jquery.com/jquery.min.js"></script>
<script>
function login(){
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    let userInfo = {};

    userInfo.username = email;
    userInfo.password = password;

    $.ajax({
        type: "post",
        url: "/login",
        data: userInfo,
        success: function(data) {
            alert('성공');
            console.log(data);
            location.href="/"
        },
        error: function(e){
            alert('error!!');
        }
    });
}
</script>
</html>