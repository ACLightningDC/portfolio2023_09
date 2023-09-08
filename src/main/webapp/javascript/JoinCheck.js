/**
 * 
 */
 
 function namesendEmail() {    //  사용하기를 눌렀을 경우 창을 닫고 입력값 전송
    opener.document.f.email.value = document.emailForm.email.value;
    window.close();
 }
 function namesendId() {    //  사용하기를 눌렀을 경우 창을 닫고 입력값 전송
    opener.document.f.userid.value = document.idForm.userid.value;
    window.close();
 }
 
