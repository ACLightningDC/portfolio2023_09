<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container-fluid d-grid col-8 mx-auto">
	<div class="row">
		<div class="col ">
			<table class="table table-striped table-bordered">
			
			<tr>
				<th scope="row">아이디</th>
				<td><input type= "text" name="userid" value="${sessionScope.userinfo.userid}">
				<button>아이디 중복확인</button></td>
			</tr>	
			<tr>
				<th scope="row">비밀번호</th>
				<td><button>비밀번호 변경하기</button></td>
			</tr>
			<tr>
				<th scope="row">이메일</th>
				<td>${sessionScope.userinfo.email}</td>
			</tr>
			<tr>
				<th scope="row">휴대폰</th>
				<td>${sessionScope.userinfo.phone}</td>
			</tr>
			<tr>
				<th scope="row">생일</th>
				<td>${sessionScope.userinfo.birthday}</td>
			</tr>
			<tr>
				<th scope="row">등급</th>
				<td>${sessionScope.userinfo.grade}</td>
			</tr>
			<tr>
				<th scope="row">기본주소</th>
				<td></td>
			</tr>
			
			</table>
		</div>
	</div>
	<div class="row my-1">
		<div class="d-grid col-8 mx-auto">
			<button class="btn btn-primary" type="button" onclick="location.href='AddressForm.shop'">주소 관리하기</button>
		</div>
	</div>
	<div class="row my-5">
		<div class="d-grid col-8 mx-auto">
			<button class="btn btn-danger" onclick="location.href='myImformationDelete.shop'">회원탈퇴</button>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col">
			<input type= "text" name="userid" value="${sessionScope.userinfo.userid}">
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



</body>
</html>