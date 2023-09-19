/**
 * 
 */
 
 function namesendEmail() {    //  사용하기를 눌렀을 경우 창을 닫고 입력값 전송
 	const regex_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	    if (!regex_email.test(document.emailForm.email.value)) {
    alert("유효하지 않은 이메일입니다.");
    $("#email").focus();
    return;
	}
    opener.document.f.email.value = document.emailForm.email.value;
    window.close();
 }
 function namesendId() {    //  사용하기를 눌렀을 경우 창을 닫고 입력값 전송
 	const regex_userid = /^[a-z0-9_]{4,20}$/;
     if (!regex_userid.test(document.idForm.userid.value)) {
	alert("유효하지 않은 아이디 입니다.");
    $("#userid").focus();
    return;
	 }

    opener.document.f.userid.value = document.idForm.userid.value;
    window.close();
 }
 
function namesendB_no(){
		const regex_b_no = /^[0-9]{10}$/;
			if (!regex_b_no.test(document.Form.b_no.value)) {
    // 유효하지 않은 사업자 등록번호일 경우 메시지를 alert로 표시하고 입력 필드에 포커스 주기
    alert("유효하지 않은 사업자 등록번호입니다.");
    $("#b_no").focus();
    return;
	}
	opener.document.f.userid.value = document.Form.b_no.value;
	    window.close();
}
