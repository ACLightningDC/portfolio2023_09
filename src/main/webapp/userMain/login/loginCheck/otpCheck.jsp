<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<meta charset="UTF-8">
<title>2단계 otp 인증</title>
<script>
function OTP_submitCheck(){
	const OTP_Check = /\d{6}/;
		 let ResultForm = document.ResultForm;
	alert(ResultForm.user_code.value);
	if(!OTP_Check.test(ResultForm.user_code.value)){
		alert("6자리 숫자 띄워쓰기 없이 부탁드립니다.");
		return false;
	}
	ResultForm.submit();
}
</script>
</head>
<body>

<div class="container-fluid col-8 mx-auto my-auto">
	<div class="card shadow mb-4">
		<div class="card-header ">
		Google Authenticator 를 이용한 2단계 otp 인증 입니다 <br>
Google Authenticator 를 다운 받아 주세요<br>
<a href="https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2&hl=ko&gl=US">Google Authenticator 설치하러 가기</a>
      </div>
       	<div class="row">
			<div class="card mb-4 m-3 col-md-11 mx-auto d-flex justify-content-end text-center">
			<div>
	       당신의 키는 → ${encodedKey} 입니다. <br>
			<div id="area">
				<img alt="" src="${url}">
			</div>
			<div>
				<form action="OTPResult.User" method="get" name="ResultForm">
			    code : <input name="user_code" type="text" placeholder="000000"><br><br>
			     <input name="loginCheck" type="hidden" readonly="readonly" value="${loginCheck}">
			    <input name="encodedKey" type="hidden" readonly="readonly" value="${encodedKey}">
			    <input name="ipAddress" type="hidden" readonly="readonly" value="${ipAddress}">
			    <input name="model" type="hidden" readonly="readonly" value="${model}">
			    <input name="Check2" type="hidden" readonly="readonly" value="${Check2}">
			    <c:if test="${Check == 1}">
			    이 기기의 2단계 인증 다시 필수로 하기(재인증 필요)<input type="checkbox" name="secu_check" value="0">
			    </c:if>
			    <c:if test="${Check != 1}">
			    다음 이 기기의 2단계 인증 생략<input type="checkbox" name="secu_check" value="1"><br>
			    </c:if>
			    <input class="btn btn-primary"type="submit" value="인증" onclick="OTP_submitCheck(); return false;">
			</form>
			
		    <c:if test="${Check == 1}">
				<hr>
				<form action="OTPResult.User">
				    <input name="loginCheck" type="hidden" readonly="readonly" value="${loginCheck}">
				    <input name="Check" type="hidden" readonly="readonly" value="${Check}">
				    <input type="submit" value="2단계 인증 생략 체크한 기기입니다. 2단계 보안 지나가기">
				</form>	    
		    </c:if>
			</div>
	      </div>
			
			</div>
		</div>
	</div>
</div>



</body>
</html>