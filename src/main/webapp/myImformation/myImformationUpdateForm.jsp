<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col">
			유저아이디<input type= "text" name="userid" value="${sessionScope.userinfo.userid}">
		</div>
	</div>
</div>
<form action="usersupdateAction.shop" method="post">
<label for=""></label>
<br>유저아이디<input type= "text" name="userid" value="${sessionScope.userinfo.userid}">
<button>비밀번호 변경하기</button>
<br>유저 이름<input type= "text" name="name" value="${sessionScope.userinfo.name}">
<br>유저 전화번호<input type= "text" name="phone" value="${sessionScope.userinfo.phone}">
<br>유저 생일<input type= "date" name="birthday" value="${sessionScope.userinfo.birthday}">
<br><input type= "submit" value="입력 확인">
</form>
아이디 ${sessionScope.userinfo.userid}<br>
이름 ${sessionScope.userinfo.name}<br>
가입일시 ${sessionScope.userinfo.date}<br>
이메일 ${sessionScope.userinfo.email}<br>
휴대폰 ${sessionScope.userinfo.phone}<br>
생일 ${sessionScope.userinfo.birthday}<br>
등급 ${sessionScope.userinfo.grade}<br>


<button onclick="location.href='AddressAdd.shop'">주소 추가하기</button>

</body>
</html>