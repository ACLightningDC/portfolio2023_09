<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/resource/javascript/JoinCheck.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script type="text/javascript">
	var action = 0;
function IdChange(){
	var CheckButton = document.getElementById('CheckButton');
	var divText = document.getElementById('divText');
	
	divText.innerText="이메일이 수정되었습니다. 다시 확인 부탁드립니다";
	
	CheckButton.remove();
	
	}

</script>
</head>
<body>
	<form method="get" action="accountEmailCheckAction.shop" name="emailForm">

<div class="container">
		<div class="container-fluid p-2">
			<div class= "row py-3">
				<div class="col">
					<label for="email" class="form-label">이메일 확인</label>
					<input id = "email" class="form-control" name="email" type="email" value="${param.email}" required="required" onchange="IdChange()">			
				</div>
			</div>
			<div class="row py-3">
				<div class="d-grid col mx-auto">
					<input class="btn btn-primary" type="submit" value="확인하기">
				</div>
			</div>
			<c:choose>
				<c:when test="${1 == checkEmail}">
					<div class= "row py-3">
						<div id= "divText" class="col">
								사용가능한 이메일입니다				
						</div>
					</div>
					<div class="row py-3">
						<div class="col d-grid mx-auto">
							<button id="CheckButton"class="btn btn-primary" type="button" onclick="namesendEmail()">이 이메일로 결정 </button>
						</div>
					</div>
				</c:when> 
				<c:when test="${2 == checkEmail}">
								<div class= "row py-3" >
					<div class="col" >
							사용불가능한 이메일 입니다				
					</div>
				</div>
				</c:when>
				
				<c:when test="${empty checkEmail}">
				<div class= "row py-3">
					<div class="col" >
							이메일 확인 부탁드립니다.				
					</div>
				</div>
				</c:when>
			</c:choose>
		</div>
</div>


	</form>
</body>
</html>