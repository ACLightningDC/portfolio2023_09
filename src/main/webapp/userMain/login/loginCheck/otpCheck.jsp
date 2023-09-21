<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2단계 otp 인증</title>
<style>

#qr_code {
}
</style>
</head>
<body>

<div>

</div>
Google Authenticator 를 이용한 2단계 otp 인증 입니다 
Google Authenticator 를 다운 받아 주세요
<a href="https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2&hl=ko&gl=US">Google Authenticator 설치하러 가기</a>
당신의 키는 → ${encodedKey } 입니다. <br>
<div id="area">
	<img alt="" src="${url}">
</div>
당신의 바코드 주소는 → ${url} 입니다. <br><br>
 
	<form action="OTPResult.User" method="get">
	    code : <input name="user_code" type="text"><br><br>
	     <input name="loginCheck" type="hidden" readonly="readonly" value="${loginCheck}">
	    <input name="encodedKey" type="hidden" readonly="readonly" value="${encodedKey}">
	    <input name="ipAddress" type="hidden" readonly="readonly" value="${ipAddress}">
	    <input name="model" type="hidden" readonly="readonly" value="${model}">
	    <input name="Check2" type="hidden" readonly="readonly" value="${Check2}">
	    <c:if test="${Check == 1}">
	    이 기기의 2단계 인증 다시 필수로 하기(재인증 필요)<input type="checkbox" name="secu_check" value="0">
	    </c:if>
	    <c:if test="${Check != 1}">
	    다음 이 기기의 2단계 인증 생략<input type="checkbox" name="secu_check" value="1">
	    </c:if>
	    <input type="submit" value="인증">
	</form>
	<br><br>
	<hr>
	    <c:if test="${Check == 1}">
	<form action="OTPResult.User">
	    <input name="loginCheck" type="hidden" readonly="readonly" value="${loginCheck}">
	    <input name="Check" type="hidden" readonly="readonly" value="${Check}">
	    <input type="submit" value="2단계 인증 생략 체크한 기기입니다. 2단계 보안 지나가기">
	</form>	    
	    </c:if>
</body>
</html>