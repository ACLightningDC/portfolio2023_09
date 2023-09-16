<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#infoTable th {
		text-align: center;
	}
</style>
</head>
<body>
<script type="text/javascript">
</script>
<div>
	<div class="container-fluid my-5">
		<div class="row">
			<div class="col-8 mx-auto ">
			
				<table class="table table-striped table-bordered" id="infoTable">
				<tr>
					<th scope="row">아이디</th>
					<td>${sessionScope.userinfo.userid}</td>
				</tr>	
				<tr>
					<th scope="row">이름</th>
					<td>${sessionScope.userinfo.name}</td>
				</tr>
				<tr>
					<th scope="row">가입일시</th>
					<td>${sessionScope.userinfo.date}</td>
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
				
				</table>
				<button class="btn btn-primary" onclick="location.href='myImformationUpdateForm.User'">내 정보 변경하기</button>
				<button class="btn btn-primary" onclick="location.href='#'">2단계 보안설정하기</button>		
			</div>
		</div>
		<div class="row my-5">
			<div class="d-grid col-8 mx-auto">
				<button class="btn btn-danger" onclick="location.href='myImformationDelete.shop'">회원탈퇴</button>
			</div>
		</div>
	</div>
</div>



</body>
</html>