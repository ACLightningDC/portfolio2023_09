<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

아이디 ${sessionScope.userinfo.userid}<br>
이름 ${sessionScope.userinfo.name}<br>
가입일시 ${sessionScope.userinfo.date}<br>
이메일 ${sessionScope.userinfo.email}<br>
휴대폰 ${sessionScope.userinfo.phone}<br>
생일 ${sessionScope.userinfo.birthday}<br>
등급 ${sessionScope.userinfo.grade}<br>

<button onclick="location.href=''">내 정보 변경하기</button>
</body>
</html>