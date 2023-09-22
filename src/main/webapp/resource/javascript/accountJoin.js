/**
 * 
 */


function CheckAllSubmit(accountForm){
	const regex_password =/^[a-z0-9_]{4,20}$/;
	const regex_phone = /^\d{3}\d{3,4}\d{4}$/;
	
	
    if (!regex_password.test(password.value)) {
    alert("유효하지 않은 비밀번호입니다.");
    $("#password").focus();
    return false;
	}
	
	else if (name.value) {
    alert("이름 입력 부탁드립니다.");
    $("#name").focus();
    return false;
	}
    else if (!regex_phone.test(phone.value)) {
    alert("휴대전화 번호 부탁드립니다.");
    $("#phone").focus();
    return false;
	}
	
	document.getElementById("acountForm").submit();
}


 function check_email(){
	 
 url="accountEmailCheck.User?email="+document.f.email.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"이메일 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }
 
 function LoginSubmit(loginForm){
	loginForm.model.value = modelCheck();
	loginForm.submit();
}
 
 function check_id(){
	 
 url="accountUseridCheck.User?userid="+document.f.userid.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"id 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }
 
 function joinComRegCheck(){
	 
 url="accountB_noCheck.User?userid="+document.f.b_no.value;
 var popupWidth = 500;
 var popupHeight = 400;
 
 var popupX = (window.screen.width/ 2)-(popupWidth / 2);
 var popupY = (window.screen.height/ 2)-(popupHeight / 2);
 open(url,"사업자 등록번호 중복체크",'width='+popupWidth+',height='+popupHeight+',left='+popupX+',top='+popupY);
 
 }
 