/**
 * 
 */


function CheckAllSubmit(accountForm){
	const regex_userid = /^[a-z0-9_]{4,20}$/;
	const regex_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	const regex_password =/^[a-z0-9_]{4,20}$/;
	const regex_name = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; 
	const regex_phone = /^\d{3}-\d{3,4}-\d{4}$/;
	const regex_b_no = /^[0-9]{10}$/;
	

	
    if (!regex_userid.test(userid.value)) {
    alert("유효하지 않은 아이디 입니다.");
    $("#userid").focus();
    return;
	}
	
    if (!regex_email.test(email.value)) {
    alert("유효하지 않은 이메일입니다.");
    $("#email").focus();
    return;
	}
	
    if (!regex_password.test(password.value)) {
    alert("유효하지 않은 비밀번호입니다.");
    $("#password").focus();
    return;
	}
	
    if (!regex_name.test(name.value)) {
    alert("한글 이름 부탁드립니다.");
    $("#name").focus();
    return;
	}
    if (!regex_phone.test(phone.value)) {
    alert("휴대전화 번호 부탁드립니다.");
    $("#phone").focus();
    return;
	}
	
	if (!regex_b_no.test(b_no.value)) {
    // 유효하지 않은 사업자 등록번호일 경우 메시지를 alert로 표시하고 입력 필드에 포커스 주기
    alert("유효하지 않은 사업자 등록번호입니다.");
    $("#b_no").focus();
    return;
	}
	accountForm.submit();
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
 