<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	     
	    <input name="encodedKey" type="hidden" readonly="readonly" value="${encodedKey }">
	    <input type="submit" value="전송!">
	     
	</form>
</body>
</html>