<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en" >
  <head>
<link rel="stylesheet"href = "${pageContext.request.contextPath}/resource/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
    Kakao.init('0b5733d74f6c32b9701c8c6784906f07');
    function kakaoLogin() {
        Kakao.Auth.login({
            success: function (response) {
                Kakao.API.request({
                    url: '/v2/user/me',
                    success: function (response) {
                        alert(JSON.stringify(response));
    					                    
                        document.getElementById("snsId").value= response.id
                        document.getElementById("snsEmail").value= response.kakao_account.email
                        document.getElementById("snsSubmitForm").submit();
                        
                    },
                    fail: function (error) {
                        alert(JSON.stringify(error))
                    },
                })
            },
            fail: function (error) {
                alert(JSON.stringify(error))
            },
        })
    }
</script>
<script type="text/javascript">
/* 	var value = document.cookie.match('(^|;) ?' + '${user_id}' + '=([^;]*)(;|$)');
	if value ? value[2] : null; */
</script>
<script src="https://cdn.jsdelivr.net/npm/mobile-detect@1.4.5/mobile-detect.min.js"></script>
<script>
function modelCheck(){
	var md = new MobileDetect(navigator.userAgent);
	
	let model= "";
	if(md.mobile()){
		model = "phone"
	}
	else if(md.mobile()){
		model = "phone"
	}
	else if(md.mobile()){
		model = "tablet"
	}
	else if(isDesktopOS()){
		model = "PC"
	}
	
	return model;
}

function isDesktopOS(){
	return ( 'win16|win32|win64|windows|mac|macintel|linux|freebsd|openbsd|sunos'.indexOf(navigator.platform.toLowerCase()) >= 0 );
}

function LoginSubmit(loginForm){
	loginForm.model.value = modelCheck();
	loginForm.submit();
}
</script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인</title>

    <style>
    	#loginMain{
    		  max-width: 450px;
  				padding: 1rem;
  				background-color:; 
    	}
    </style>
  </head>



  
<body class="d-flex flex-column min-vh-100 bg-body-tertiary" >



<main id="loginMain" class="form-signin w-100 m-auto">
  <form action="login.shop" method="post" id="loginForm" onsubmit="LoginSubmit(this)" >
    <h3 id="MainHead"class="h3 mb-3 fw-normal">아이디 로그인</h3>

    <div class="form-floating py-1">
      <input type="text" name = "userid" value ="${cookie.user_id.value}" class="form-control" id="floatingInput" placeholder="" required="required">
      <div class="invalid-feedback">아이디를 입력하세요</div>
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating py-1">
      <input type="password" name ="password" class="form-control" id="floatingPassword" placeholder="Password" required="required">
                <div class="invalid-feedback">비밀번호를 입력하세요</div>
      <label for="floatingPassword">비밀번호</label>
    </div>

    <div class="form-check text-start my-3 justify-content-between d-flex justify-content-between align-items-center">
	    <div>
	      <input id = "idremind" class="form-check-input" name ="checkbox" type="checkbox"  value="remember-me" id="flexCheckDefault" ${null != cookie.user_id.value ?  "checked=\"checked\"": ""}>
	      <label class="form-check-label" for="flexCheckDefault">
	        아이디 기억하기
	      </label>
	    </div>
      <div class="btn-group" role="group">
    	<a class="btn btn-outline-primary btn-sm" href="findIdForm.User">아이디 찾기</a>
		<a class="btn btn-outline-primary btn-sm" href="PasswordFindFrom.User">비밀번호 찾기</a>	
      </div>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit" >로그인</button>
    <hr>
		<input type="hidden" name = "model" value =""  id="modelId">
  </form>
    <button class="btn btn-outline-primary w-100 py-2" type="button" onclick="location.href='account.shop'">회원가입</button>
    <button class="btn btn-outline-primary w-100 py-2" type="button" onclick="kakaoLogin()">카카오 로그인 하기</button>
    <p class="mt-5 mb-3 text-body-secondary">&copy; HomeShopping Corp.</p>
</main>
<div style="display: none;">
	<form action="snsLogin.User" method="post" id="snsSubmitForm">
		<input type="text" name="snsId" id="snsId" value="">
		<input type="text" name="snsEmail" id="snsEmail" value="">
	</form>
</div>

    </body>
</html>
