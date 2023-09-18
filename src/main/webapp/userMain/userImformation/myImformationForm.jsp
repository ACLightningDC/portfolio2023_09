<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 보기</title>
<style>
	#infoTable th {
		text-align: center;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mobile-detect/1.4.5/mobile-detect.min.js"></script>
<script>
var md = new MobileDetect(navigator.userAgent);

console.log( md.mobile() );          // 'Sony'
console.log( md.phone() );           // 'Sony'
console.log( md.tablet() );          // null
console.log( md.userAgent() );       // 'Safari'
console.log( md.os() );              // 'AndroidOS'
console.log( md.is('iPhone') );      // false
console.log( md.is('bot') );         // false
console.log( md.version('Webkit') );         // 534.3
console.log( md.versionStr('Build') );       // '4.1.A.0.562'
console.log( md.match('playstation|xbox') ); // false


function isDesktopOS(){
	return ( 'win16|win32|win64|windows|mac|macintel|linux|freebsd|openbsd|sunos'.indexOf(navigator.platform.toLowerCase()) >= 0 );
}

if(isDesktopOS()){
	
}
</script>
</head>
<body>
<div class="modal fade"  id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">2단계 보안설정하기</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        로그인 시 
        ip 와 기기정보를 대조한뒤 <br>
        새로운 기기 아이피 에서 요청된 로그인일 경우<br>
         이메일 인증을 실행합니다.
         <hr>
         보안 설정 취소시 ip 정보와 기기 정보는 삭제됩니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        
        <button type="button" class="btn btn-primary" onclick="location.href='user_securitySetting.User'">2단계 보안설정</button>
        <button type="button" class="btn btn-primary" onclick="location.href='user_securityCancel.User'">2단계 보안설정 취소</button>
      </div>
    </div>
  </div>
</div>
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
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
				  2단계 보안설정하기
				</button>
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