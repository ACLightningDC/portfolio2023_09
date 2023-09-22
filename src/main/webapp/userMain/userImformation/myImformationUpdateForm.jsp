<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    	<script src="${pageContext.request.contextPath}/resource/javascript/user/update.js"></script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<form method="post" action="myImformationUpdateaAction.User" id="updateForm" name="f">

<div class="container-fluid d-grid col-8 mx-auto">
	<div class="row">
		<div class="col ">
			<h5>${updateMessage}</h5>
			<table class="table table-striped table-bordered">
			<tr>
				<th scope="row">아이디</th>
				<td><input type= "text" name="userid" value="${sessionScope.userinfo.userid}" readonly="readonly" required="required">
				<button onclick="check_id()">아이디 중복확인</button></td>
			</tr>	
			<tr>
				<th scope="row">비밀번호</th>
				<td>비밀번호<input type= "password" name="password" id="password" value=""></td>
			</tr>
			<tr>
				<th scope="row">유저이름</th>
				<td>유저 이름<input type= "text" name="name" id="name" value="${sessionScope.userinfo.name}"></td>
			</tr>
			<tr>
				<th scope="row">이메일</th>
				<td>이메일<input type= "text" name="email" value="${sessionScope.userinfo.email}"readonly="readonly" required="required">
				<button type="button" onclick="check_email()">이메일 변경하기</button></td>
				
			</tr>
			<tr>
				<th scope="row">휴대폰</th>
				<td><input type= "text" name="phone" id="phone" value="${sessionScope.userinfo.phone}"></td>
			</tr>
			<tr>
				<th scope="row">등급</th>
				<td>${sessionScope.userinfo.grade}
				<c:choose>
					<c:when test="${sessionScope.userinfo.grade == 'N'}">일반 등급 입니다. 지난달 구매액 100000 원이 넘으면 3등급이 됩니다</c:when>
					<c:when test="${sessionScope.userinfo.grade == 'S'}">판매자 입니다.</c:when>
					<c:otherwise></c:otherwise>				
				</c:choose>
				
				</td>
				
				
			</tr>
			<tr>
				<th scope="row">기본주소</th>
				<td>${sessionScope.userinfo.address_id == -1 ?"기본주소를 선택해 주세요":sessionScope.userinfo.address_id}</td>
			</tr>
			
			</table>
		</div>
	</div>

	<div class="row my-1">
		<div class="d-grid  mx-auto">
			<button class="btn btn-primary" type="submit" onclick="CheckAllSubmit(this)">정보 수정</button>
		</div>
	</div>
	<input class="btn btn-secondary" type="reset" value="초기값으로">
</form>

	<div class="row my-1">
		<div class="d-grid mx-auto">
			<button class="btn btn-primary" type="button" onclick="location.href='AddressForm.address'">주소 관리 , 선택하기</button>
		</div>
	</div>
	<div class="row my-5">
		<div class="d-grid col-8 mx-auto">
			<button class="btn btn-danger" onclick="location.href='myImformationDelete.shop'">회원탈퇴</button>
		</div>
	</div>
</div>



</body>
</html>