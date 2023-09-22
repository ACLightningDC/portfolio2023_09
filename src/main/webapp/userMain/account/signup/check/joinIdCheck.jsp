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
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script type="text/javascript">
	var action = 0;
function IdChange(){
	//if(action == 0) {return action += 1;}
	var CheckButton = document.getElementById('CheckButton');
	var divText = document.getElementById('divText');
	
	divText.innerText="아이디가 수정되었습니다. 다시 확인 부탁드립니다";
	
	CheckButton.remove();
	
	}
</script>
<c:set var="CheckId" value="${requestScope.checkUserid}"></c:set>
</head>
<body>
	<form method="get" action="accountUseridCheckAction.shop" name="idForm">
	
<div class="container">
		<div class="container-fluid p-2">
			<div class= "row py-3">
				<div class="col">
					<label for="userid" class="form-label" >아이디 확인</label>
					<input id = "userid" class="form-control" name="userid" type="text" value="${param.userid}" required="required" onchange="IdChange()">			
				</div>
			</div>
			<div class="row py-3" >	
				<div class="d-grid col mx-auto">
					<input class="btn btn-primary" type="submit" value="확인하기">
				</div>
			</div>
			<c:choose>
				<c:when test="${1 == CheckId}">
				<div class= "row py-3">
					<div id="divText" class="col" id="DivText">
							사용가능한 아이디입니다				
					</div>
				</div>
				<div class="row py-3">
					<div class="col d-grid mx-auto" id="button" >
						<button id="CheckButton" class="btn btn-primary" type="button" onclick="namesendId()">이 아이디로 결정 </button>
					</div>
				</div>
				</c:when> 
				<c:when test="${2 == CheckId}">
								<div class= "row py-3" >
					<div class="col" >
							사용불가능한 아이디입니다				
					</div>
				</div>
				</c:when>
				
				<c:when test="${empty CheckId}">
				<div class= "row py-3">
					<div class="col" >
							아이디 확인 부탁드립니다.				
					</div>
				</div>
				</c:when>
			</c:choose>
		</div>
</div>


	</form>
</body>
</html>