<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<style>
.accountSelectBox{
	border: solid 1px black;
	height: 18rem;
}

</style>
</head>
<body>


<div class="container text-center">

	<div class="row">
	<div class="col">
				<button type="button" onclick="location.href='accountUsers.shop'" class="btn btn-primary btn-lg">개인 구매자 회원가입</button>
	</div>
				
		<div class="col">
					<button type="button" onclick="location.href='accountBuisness.shop'" class="btn btn-primary btn-lg">사업자 회원가입</button>
		</div>	
	</div>
</div>

</body>
</html>